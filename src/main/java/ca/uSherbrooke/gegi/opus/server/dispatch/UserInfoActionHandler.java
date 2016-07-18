package ca.uSherbrooke.gegi.opus.server.dispatch;


import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfoResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class UserInfoActionHandler implements ActionHandler<UserInfo, UserInfoResult> {

    @Inject
    UserService userService;

    @Inject
    public UserInfoActionHandler() {

    }

    @Override
    public UserInfoResult execute(UserInfo user, ExecutionContext context) throws ActionException {
        UserInfoResult userResult;
        boolean bSuccess = false;

        if (user.getSaveStudent() == true) {
            userResult = new UserInfoResult();
            if (userService.insertUserInfos(user) == true) {
                bSuccess = true;
            }
        } else if (user.getUpdateStudent() == true) {
            userResult = new UserInfoResult();
            if (userService.updateUserInfos(user) == true) {
                bSuccess = true;
            }
            bSuccess = true;
        } else if (user.getGetStudent() == true) {
            if (user.getStagiaireID() == -1 && user.m_strCIP != "") { // get with cip
                userResult = new UserInfoResult(userService.getUserInfosWithCIP(user));
                bSuccess = true;
            }else if (user.getStagiaireID() == -1 && user.m_strCIP == "") { // get next
                userResult = new UserInfoResult(userService.getNextUserInfos(user));
                bSuccess = true;
            } else if (user.getStagiaireID() >= 0) { // get with stagiaire ID
                userResult = new UserInfoResult(userService.getUserInfos(user));
                bSuccess = true;
            } else {
                //Error
                userResult = new UserInfoResult();
            }
        } else {
            //Error
            userResult = new UserInfoResult();
        }
        if (bSuccess == true) {
            userResult.setSaveSuccess(true);
        }
        return userResult;
    }

    @Override
    public void undo(UserInfo action, UserInfoResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<UserInfo> getActionType() {
        return UserInfo.class;
    }
}
