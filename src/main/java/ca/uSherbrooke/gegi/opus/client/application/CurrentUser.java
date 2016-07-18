package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.commons.core.server.utils.UserSessionImpl;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfoResult;
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
    String _cip = _session.getAdministrativeUserId();
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
            answerFromServer = true;
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
            answerFromServer = false;
        }
    };
}
