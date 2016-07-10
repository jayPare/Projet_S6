package ca.uSherbrooke.gegi.opus.server.dispatch;


import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.setUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.setUserInfosResult;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import java.util.List;

public class UserInfosActionHandler implements ActionHandler<GetUserInfos, GetUserInfosResult> {

    @Inject
    UserService userService;

    @Inject
    public UserInfosActionHandler() {

    }

    @Override
    public GetUserInfosResult execute(GetUserInfos user, ExecutionContext context) throws ActionException {
        GetUserInfosResult userResult;
        boolean bSuccess = false;

        if (user.getSaveStudent() == true) {
            userResult = new GetUserInfosResult();
            if (userService.insertUserInfos(user) == true) {
                bSuccess = true;
            }
        } else if (user.getUpdateStudent() == true) {
            userResult = new GetUserInfosResult();
            if (userService.updateUserInfos(user) == true) {
                bSuccess = true;
            }
            bSuccess = true;
        } else if (user.getGetStudent() == true) {
            if (user.getStagiaireID() == -1) {
                userResult = new GetUserInfosResult(userService.getUserInfos(user));
                bSuccess = true;
            } else if (user.getStagiaireID() >= 0) {
                userResult = new GetUserInfosResult(userService.getNextUserInfos(user));
                bSuccess = true;
            } else {
                //Error
                userResult = new GetUserInfosResult();
            }
        } else {
            //Error
            userResult = new GetUserInfosResult();
        }
        if (bSuccess == true) {
            userResult.setSaveSuccess(true);
        }
        return userResult;
    }

    @Override
    public void undo(GetUserInfos action, GetUserInfosResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<GetUserInfos> getActionType() {
        return GetUserInfos.class;
    }
}
