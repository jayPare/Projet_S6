package ca.uSherbrooke.gegi.opus.server.dispatch;

import ca.uSherbrooke.gegi.opus.server.service.UserService;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfoResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by Fabul on 2016-07-10.
 */
public class MatchInfoActionHandler implements ActionHandler<MatchInfo, MatchInfoResult> {
    @Inject
    UserService userService;

    @Override
    public MatchInfoResult execute(MatchInfo match, ExecutionContext executionContext) throws ActionException {
        MatchInfoResult matchResult = null;
        boolean bSuccess = false;

        if (match.getSaveEmployerMatch() == true) {
            matchResult = new MatchInfoResult();
            if (userService.saveMatchEmployer(match) == true) {
                bSuccess = true;
            }
        } else if (match.getSaveStudentMatch() == true) {
            matchResult = new MatchInfoResult();
            if (userService.saveMatchStagiaire(match) == true) {
                bSuccess = true;
            }
        } else if (match.getGetStagiaireMatch() == true) {
            matchResult = new MatchInfoResult(userService.getMatchEmployer(match));
            bSuccess = true;
            //getMatchEmployer
        } else if (match.getGetEmployerMatch() == true) {
            matchResult = new MatchInfoResult(userService.getMatchStagiaire(match));
            bSuccess = true;
        } else {
            //Error
            matchResult = new MatchInfoResult();
        }
        if (bSuccess == true) {
            matchResult.setSaveSuccess(true);
        }
        return matchResult;
    }

    @Override
    public Class<MatchInfo> getActionType() {
        return null;
    }

    @Override
    public void undo(MatchInfo MatchInfo, MatchInfoResult MatchInfoResult, ExecutionContext executionContext) throws ActionException {

    }
}
