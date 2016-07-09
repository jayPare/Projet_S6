package ca.uSherbrooke.gegi.opus.server.dispatch;


import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.setUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.setUserInfosResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class UserInfosActionHandler implements ActionHandler<GetUserInfos, GetUserInfosResult> {

    @Inject
    UserService userService;

    @Inject
    public UserInfosActionHandler() {

    }

    @Override
    public GetUserInfosResult execute(GetUserInfos action, ExecutionContext context) throws ActionException {
        return new GetUserInfosResult(userService.getUserInfos(action));
    }

    @Override
    public void undo(GetUserInfos action, GetUserInfosResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<GetUserInfos> getActionType() {
        return GetUserInfos.class;
    }
}
