package ca.uSherbrooke.gegi.opus.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by Fabul on 2016-06-20.
 */
public class GetEmployerInfos extends ActionImpl<GetEmployerInfosResult> {

    int nEmployerID;

    public GetEmployerInfos() {
    }

    public void setEmployerID(int nEmployerID) {
        this.nEmployerID = nEmployerID;
    }

    public boolean isSecured() {
        return false;
    }
}
