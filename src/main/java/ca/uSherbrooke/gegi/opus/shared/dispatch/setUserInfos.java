package ca.uSherbrooke.gegi.opus.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by tomaslopinto on 07/07/16.
 */


    public class setUserInfos extends ActionImpl<GetUserInfosResult> {

        String strCIP = "";

        public setUserInfos() {
        }

        public void setCIP(String strCIP) {
            this.strCIP = strCIP;
        }

        public boolean isSecured() {
            return false;
        }
    }