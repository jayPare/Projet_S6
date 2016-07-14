package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.commons.core.server.utils.UserSessionImpl;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rpc.server.Dispatch;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;

import javax.servlet.http.HttpServletRequest;

import static com.google.web.bindery.requestfactory.server.RequestFactoryServlet.getThreadLocalRequest;

/**
 * Created by Genie on 10/juil./2016.
 */
public class CurrentUser {
    HttpServletRequest _request = getThreadLocalRequest();
    UserSessionImpl _session = new UserSessionImpl(_request);
    String _cip = _session.getAdministrativeUserId();
    DispatchAsync dispatchAsync;
    private GetUserInfosResult _user;
    private Boolean answerFromServer = null;

    public Boolean IsLoggedIn()
    {
        GetUserInfos objUserInfo = new GetUserInfos();
        GetUserInfosResult objUserInfoResults = new GetUserInfosResult();
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

    private AsyncCallback<GetUserInfosResult> userInfosAsyncCallback = new AsyncCallback<GetUserInfosResult>() {
        @Override
        public void onSuccess(GetUserInfosResult result) {
            answerFromServer = true;
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
            answerFromServer = false;
        }
    };
}
