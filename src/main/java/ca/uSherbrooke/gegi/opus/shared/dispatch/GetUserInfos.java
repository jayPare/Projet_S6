package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by Fabul on 2016-05-31.
 */

public class GetUserInfos extends ActionImpl<GetUserInfosResult> {

    String strCIP = "";
    boolean bRetriveUserInfos = false;

    public GetUserInfos() {
    }

    public void setCIP(String strCIP) {
        this.strCIP = strCIP;
    }

    public void setRetriveUserInfos(boolean bRetriveUserInfos) {
        this.bRetriveUserInfos = bRetriveUserInfos;
    }
}
