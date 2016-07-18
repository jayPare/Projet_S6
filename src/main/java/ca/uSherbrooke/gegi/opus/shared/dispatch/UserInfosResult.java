package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-05-31.
 */

@SuppressWarnings("serial")
public class GetUserInfosResult implements Result {

    private UserInfosData objUserInfoData;
    private boolean bSaveSuccess = false;

    public GetUserInfosResult() {
    }

    public GetUserInfosResult(UserInfosData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public void setUserInfosObject(UserInfosData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public UserInfosData getUserInfosObject() {
        return this.objUserInfoData;
    }

    public void setSaveSuccess(boolean bSaveSuccess) {
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess() {
        return this.bSaveSuccess;
    }
}
