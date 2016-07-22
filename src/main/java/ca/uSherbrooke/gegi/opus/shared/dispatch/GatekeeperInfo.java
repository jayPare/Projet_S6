package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

import java.util.List;

/**
 * Created by Fabul on 2016-07-21.
 */
public class GatekeeperInfo extends ActionImpl<GatekeeperInfoResult>{
    private int m_nStagiaireID = -1;
    private int m_nEmployerID = -1;
    public String m_strCIP = "";

    public GatekeeperInfo() {
    }

    public void setUserCIP(String strCIP) {
        this.m_strCIP = strCIP;
    }

    public boolean isSecured() {
        return false;
    }
}

