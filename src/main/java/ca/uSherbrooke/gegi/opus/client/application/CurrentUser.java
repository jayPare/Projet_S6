package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.shared.dispatch.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;

/**
 * Created by Genie on 10/juil./2016.
 */
public class CurrentUser {

    //TODO: Delete
    /*//--> Pretty sure it is server-side, but not sure how...
    //--> Check CurrentUserInfoResult to manage that

    //HttpServletRequest _request = getThreadLocalRequest();
    //UserSessionImpl _session = new UserSessionImpl(_request);
    //private String _cip = _session.getAdministrativeUserId();
    private int _stagiaireID = 0;
    private int _employerID = 0;
    private String _cip = "";
    private boolean _bIsEmployer = false;
    private Boolean answerFromServer = null;

    DispatchAsync dispatchAsync;

    public CurrentUser()
    {

    }

    public void getCurrentUser() {
        CurrentUserInfo currentUser = new CurrentUserInfo();
        currentUser.m_strCIP = "asdasds";
        dispatchAsync.execute(currentUser, currentUserInfosAsyncCallback);
        /*while (answerFromServer == null) {

        }
    }

    private AsyncCallback<CurrentUserInfoResult> currentUserInfosAsyncCallback = new AsyncCallback<CurrentUserInfoResult>() {
        @Override
        public void onSuccess(CurrentUserInfoResult result) {
            if (result.getUserObject() != null) {
                _stagiaireID = result.getUserObject().getStagiaireID();
                _cip = result.getUserObject().getCIP();
                _bIsEmployer = false;
            } else if (result.getEmployerObject() != null) {
                _employerID = result.getEmployerObject().getEmployerId();
                _cip = result.getEmployerObject().getCIP();
                _bIsEmployer = true;
            }
            answerFromServer = true;
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
            answerFromServer = false;
        }
    };*/
}