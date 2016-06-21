package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfosResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by Fabul on 2016-06-20.
 */
public class EmployerInfosActionHandler implements ActionHandler<GetEmployerInfos, GetEmployerInfosResult>{
    @Inject
    UserService userService;

    @Inject
    public EmployerInfosActionHandler(){}


    @Override
    public GetEmployerInfosResult execute(GetEmployerInfos action, ExecutionContext context) throws ActionException {
        return new GetEmployerInfosResult(userService.getEmployerInfos(action));
    }

    @Override
    public void undo(GetEmployerInfos action, GetEmployerInfosResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<GetEmployerInfos> getActionType() {
        return GetEmployerInfos.class;
    }
}
