package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GatekeeperInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GatekeeperInfoResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class GateKeeperActionHandler implements ActionHandler<GatekeeperInfo, GatekeeperInfoResult> {
    @Inject
    UserService userService;

    @Override
    public GatekeeperInfoResult execute(GatekeeperInfo gatekeeperInfo, ExecutionContext context) throws ActionException {
        return userService.getUserWithCIP(gatekeeperInfo);
    }

    @Override
    public void undo(GatekeeperInfo action, GatekeeperInfoResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<GatekeeperInfo> getActionType() {
        return GatekeeperInfo.class;
    }
}
