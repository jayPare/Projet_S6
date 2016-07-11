package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfosResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by Fabul on 2016-06-20.
 */
public class EmployerInfosActionHandler implements ActionHandler<GetEmployerInfos, GetEmployerInfosResult> {
    @Inject
    UserService userService;

    @Inject
    public EmployerInfosActionHandler() {
    }

    @Override
    public GetEmployerInfosResult execute(GetEmployerInfos employer, ExecutionContext context) throws ActionException {
        GetEmployerInfosResult employerResult = null;
        boolean bSuccess = false;

        if (employer.getSaveEmployer() == true) {
            employerResult = new GetEmployerInfosResult();
            if (userService.insertEmployerInfos(employer) == true) {
                bSuccess = true;
            }
        } else if (employer.getUpdateEmployer() == true) {
            employerResult = new GetEmployerInfosResult();
            if (userService.updateEmployerInfos(employer) == true) {
                bSuccess = true;
            }
        } else if (employer.getGetEmployer() == true) {
            if (employer.getEmployerID() == -1 && employer.m_strCIP != "") { // get with cip
                employerResult = new GetEmployerInfosResult(userService.getEmployerInfosWithCIP(employer));
                bSuccess = true;
            } else if (employer.getEmployerID() == -1 && employer.m_strCIP == "") { // get next
                employerResult = new GetEmployerInfosResult(userService.getNextEmployerInfos(employer));
                bSuccess = true;
            } else if (employer.getEmployerID() >= 0) { //get with employer id
                employerResult = new GetEmployerInfosResult(userService.getEmployerInfos(employer));
                bSuccess = true;
            } else {
                //Error
                employerResult = new GetEmployerInfosResult();
            }
        } else {
            //Error
            employerResult = new GetEmployerInfosResult();
        }
        if (bSuccess == true) {
            employerResult.setSaveSuccess(true);
        }
        return employerResult;
    }

    @Override
    public void undo(GetEmployerInfos action, GetEmployerInfosResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<GetEmployerInfos> getActionType() {
        return GetEmployerInfos.class;
    }
}
