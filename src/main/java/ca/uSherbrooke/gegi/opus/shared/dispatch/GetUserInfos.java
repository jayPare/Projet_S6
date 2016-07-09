package ca.uSherbrooke.gegi.opus.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by Fabul on 2016-05-31.
 */

public class GetUserInfos extends ActionImpl<GetUserInfosResult>  {

    String strCIP = "";

    public GetUserInfos() {
    }

    public void setCIP(String strCIP) {
        this.strCIP = strCIP;
    }

    public boolean isSecured() {
        return false;
    }
}

