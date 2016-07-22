package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.commons.core.server.utils.UserSessionImpl;
import ca.uSherbrooke.gegi.opus.shared.dispatch.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;

import javax.servlet.http.HttpServletRequest;


import static com.google.web.bindery.requestfactory.server.RequestFactoryServlet.getThreadLocalRequest;

/**
 * Created by Genie on 10/juil./2016.
 */
public class CurrentUser {
    HttpServletRequest _request = getThreadLocalRequest();
    UserSessionImpl _session = new UserSessionImpl(_request);
    private String _cip = _session.getAdministrativeUserId();
    private int _stagiaireID = 0;
    private int _employerID = 0;
    private boolean bIsEmployer = false;
    private UserInfoResult _user;
    private Boolean answerFromServer = null;

    DispatchAsync dispatchAsync;

    public Boolean IsLoggedIn() {
        GatekeeperInfo objGatekeeperInfo = new GatekeeperInfo();
        objGatekeeperInfo.setUserCIP(_cip);
        dispatchAsync.execute(objGatekeeperInfo, gatekeeperInfosAsyncCallback);
        answerFromServer = null;
        while (answerFromServer == null) {

        }
        if (answerFromServer = true) {
            return true;
        } else {
            return false;
        }
    }

    private AsyncCallback<GatekeeperInfoResult> gatekeeperInfosAsyncCallback = new AsyncCallback<GatekeeperInfoResult>() {
        @Override
        public void onSuccess(GatekeeperInfoResult result) {
            if (result.getGatekeeperInfoObject().getStagiaireId() != -1) {
                _stagiaireID = result.getGatekeeperInfoObject().getStagiaireId();
                bIsEmployer = false;
                System.out.print("\n\n\nStudent here\n\n\n");
            } else if (result.getGatekeeperInfoObject().getEmployerId() != -1) {
                _employerID = result.getGatekeeperInfoObject().getEmployerId();
                bIsEmployer = true;
                System.out.print("\n\n\nEmployer here\n\n\n");
            }
            answerFromServer = true;
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
            answerFromServer = false;
        }
    };
}
