package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-07-10.
 */
public class MatchInfosResult implements Result {

    private boolean bSaveSuccess = false;

    private List<MatchData> m_objListMatchInfoData;

    public MatchInfosResult() {
    }

    public MatchInfosResult(List<MatchData> objListMatchInfoData) {
        this.m_objListMatchInfoData = objListMatchInfoData;
    }

    public void setMatchInfosObject(List<MatchData> objListMatchInfoData) {
        this.m_objListMatchInfoData = objListMatchInfoData;
    }

    public List<MatchData> getMatchInfosObject() {
        return this.m_objListMatchInfoData;
    }

    public void setSaveSuccess(boolean bSaveSuccess) {
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess() {
        return this.bSaveSuccess;
    }

}
