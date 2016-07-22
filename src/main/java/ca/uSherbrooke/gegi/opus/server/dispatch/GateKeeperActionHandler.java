package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.commons.core.server.utils.UserSessionImpl;
import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GatekeeperInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GatekeeperInfoResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import javax.servlet.http.HttpServletRequest;

import static com.google.web.bindery.requestfactory.server.RequestFactoryServlet.getThreadLocalRequest;

public class GateKeeperActionHandler implements ActionHandler<GatekeeperInfo, GatekeeperInfoResult> {
    @Inject
    UserService userService;

    @Override
    public GatekeeperInfoResult execute(GatekeeperInfo gatekeeperInfo, ExecutionContext context) throws ActionException {
        //HttpServletRequest request = getThreadLocalRequest();
        //UserSessionImpl session = new UserSessionImpl(request);
        gatekeeperInfo.setUserCIP("degs2601");
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
