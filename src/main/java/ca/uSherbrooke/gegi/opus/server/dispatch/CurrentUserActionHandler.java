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

    @Override
    public CurrentUserInfoResult execute(CurrentUserInfo currentUserInfo, ExecutionContext context) throws ActionException {
        //HttpServletRequest request = getThreadLocalRequest();
        //UserSessionImpl session = new UserSessionImpl(request);
        currentUserInfo.setUserCIP("degs2601"); // should not be hardcoded
        return userService.getUserWithCIP(currentUserInfo);
    }

    @Override
    public void undo(CurrentUserInfo action, CurrentUserInfoResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<CurrentUserInfo> getActionType() {
        return CurrentUserInfo.class;
    }
}
