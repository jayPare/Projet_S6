package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.CurrentUserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.CurrentUserInfoResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class CurrentUserActionHandler implements ActionHandler<CurrentUserInfo, CurrentUserInfoResult> {

    @Inject
    UserService userService;

    @Inject
    public CurrentUserActionHandler() {

    }

    @Override
    public CurrentUserInfoResult execute(CurrentUserInfo currentUserInfo, ExecutionContext executionContext) throws ActionException
    {
        CurrentUserInfoResult currentUserInfoResult = userService.getConnectedUserInfo();
        return currentUserInfoResult;
    }

    @Override
    public Class<CurrentUserInfo> getActionType() {
        return CurrentUserInfo.class;
    }

    @Override
    public void undo(CurrentUserInfo currentUserInfo, CurrentUserInfoResult currentUserInfoResult, ExecutionContext executionContext) throws ActionException
    {

    }
}
