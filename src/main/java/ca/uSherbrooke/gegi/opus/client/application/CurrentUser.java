package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.commons.core.server.utils.UserSessionImpl;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.google.web.bindery.requestfactory.server.RequestFactoryServlet.getThreadLocalRequest;

/**
 * Created by Genie on 10/juil./2016.
 */
public class CurrentUser {
    HttpServletRequest _request = getThreadLocalRequest();
    UserSessionImpl _session = new UserSessionImpl(_request);
    private String _cip = _session.getAdministrativeUserId();
    private int _stagiaireID = 0;
    private String _firstName = "";
    private String _lastName = "";
    private String _departementNom = "";
    private String _CV = "";
    private int _numeroStage = 0;
    private List<ConceptData> _interet = null;
    private List<ConceptData> _competence = null;
    DispatchAsync dispatchAsync;
    private UserInfoResult _user;
    private Boolean answerFromServer = null;

    public Boolean IsLoggedIn()
    {
        UserInfo objUserInfo = new UserInfo();
        UserInfoResult objUserInfoResults = new UserInfoResult();
        objUserInfo.getStudentWithCIP(_cip, true);
        dispatchAsync.execute(objUserInfo, userInfosAsyncCallback);
        while (answerFromServer == null)
        {

        }
        if (answerFromServer = true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private AsyncCallback<UserInfoResult> userInfosAsyncCallback = new AsyncCallback<UserInfoResult>() {
        @Override
        public void onSuccess(UserInfoResult result) {
            _stagiaireID = result.getUserInfosObject().getStagiaireID();
            _firstName = result.getUserInfosObject().getFirstName();
            _lastName = result.getUserInfosObject().getLastName();
            _departementNom = result.getUserInfosObject().getDepartementNom();
            _CV = result.getUserInfosObject().getCV();
             _numeroStage = result.getUserInfosObject().getNumeroStage();
            _interet = result.getUserInfosObject().getInteret();
            _competence = result.getUserInfosObject().getCompetence();
            answerFromServer = true;
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
            answerFromServer = false;
        }
    };
}
