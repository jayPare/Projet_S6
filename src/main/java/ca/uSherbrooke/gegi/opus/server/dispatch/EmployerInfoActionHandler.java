package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfoResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by Fabul on 2016-06-20.
 */
public class EmployerInfoActionHandler implements ActionHandler<EmployerInfo, EmployerInfoResult> {
    @Inject
    UserService userService;

    @Inject
    public EmployerInfoActionHandler() {
    }

    @Override
    public EmployerInfoResult execute(EmployerInfo employer, ExecutionContext context) throws ActionException {
        EmployerInfoResult employerResult = null;
        boolean bSuccess = false;

        if (employer.getSaveEmployer() == true) {
            employerResult = new EmployerInfoResult();
            if (userService.insertEmployerInfos(employer) == true) {
                bSuccess = true;
            }
        } else if (employer.getUpdateEmployer() == true) {
            employerResult = new EmployerInfoResult();
            if (userService.updateEmployerInfos(employer) == true) {
                bSuccess = true;
            }
        } else if (employer.getGetEmployer() == true) {
            if (employer.getEmployerID() == -1 && employer.m_strCIP != "") { // get with cip
                employerResult = new EmployerInfoResult(userService.getEmployerInfosWithCIP(employer));
                bSuccess = true;
            } else if (employer.getEmployerID() == -1 && employer.m_strCIP == "") { // get next
                employerResult = new EmployerInfoResult(userService.getNextEmployerInfos(employer));
                bSuccess = true;
            } else if (employer.getEmployerID() >= 0) { //get with employer id
                employerResult = new EmployerInfoResult(userService.getEmployerInfos(employer));
                bSuccess = true;
            } else {
                //Error
                employerResult = new EmployerInfoResult();
            }
        } else {
            //Error
            employerResult = new EmployerInfoResult();
        }
        if (bSuccess == true) {
            employerResult.setSaveSuccess(true);
        }
        return employerResult;
    }

    @Override
    public void undo(EmployerInfo action, EmployerInfoResult result, ExecutionContext context) throws ActionException {
    }

    @Override
    public Class<EmployerInfo> getActionType() {
        return EmployerInfo.class;
    }
}
