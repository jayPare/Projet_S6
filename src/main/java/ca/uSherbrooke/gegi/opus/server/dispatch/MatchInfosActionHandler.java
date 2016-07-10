package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfosResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfosResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by Fabul on 2016-07-10.
 */
public class MatchInfosActionHandler implements ActionHandler<MatchInfos, MatchInfosResult> {
    @Inject
    UserService userService;

    @Override
    public MatchInfosResult execute(MatchInfos match, ExecutionContext executionContext) throws ActionException {
        MatchInfosResult matchResult = null;
        boolean bSuccess = false;

        if (match.getSaveEmployerMatch() == true) {
            matchResult = new MatchInfosResult();
            if (userService.saveMatchStagiaire(match) == true) {
                bSuccess = true;
            }
        } else if (match.getSaveStudentMatch() == true) {
            matchResult = new MatchInfosResult();
            if (userService.saveMatchEmployer(match) == true) {
                bSuccess = true;
            }
        } else if (match.getGetStagiaireMatch() == true) {
            matchResult = new MatchInfosResult(userService.getMatchEmployer(match));
            bSuccess = true;
            //getMatchEmployer
        } else if (match.getGetEmployerMatch() == true) {
            matchResult = new MatchInfosResult(userService.getMatchStagiaire(match));
            bSuccess = true;
        } else {
            //Error
            matchResult = new MatchInfosResult();
        }
        if (bSuccess == true) {
            matchResult.setSaveSuccess(true);
        }
        return matchResult;
    }

    @Override
    public Class<MatchInfos> getActionType() {
        return null;
    }

    @Override
    public void undo(MatchInfos matchInfos, MatchInfosResult matchInfosResult, ExecutionContext executionContext) throws ActionException {

    }
}
