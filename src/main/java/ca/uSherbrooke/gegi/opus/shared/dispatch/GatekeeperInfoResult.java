package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.GatekeeperData;
import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-07-21.
 */
public class GatekeeperInfoResult implements Result {

    private boolean bSaveSuccess = false;

    private GatekeeperData m_objGatekeeperInfo;

    public GatekeeperInfoResult() {
    }

    public GatekeeperInfoResult(GatekeeperData objGatekeeperInfo) {
        this.m_objGatekeeperInfo = objGatekeeperInfo;
    }

    public void setGatekeeperInfoObject(GatekeeperData objGatekeeperInfo) {
        this.m_objGatekeeperInfo = objGatekeeperInfo;
    }

    public GatekeeperData getGatekeeperInfoObject() {
        return this.m_objGatekeeperInfo;
    }

    public void setSaveSuccess(boolean bSaveSuccess) {
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess() {
        return this.bSaveSuccess;
    }

}
