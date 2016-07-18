package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-05-31.
 */

@SuppressWarnings("serial")
public class UserInfoResult implements Result {

    private UserInfoData objUserInfoData;
    private boolean bSaveSuccess = false;

    public UserInfoResult() {
    }

    public UserInfoResult(UserInfoData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public void setUserInfosObject(UserInfoData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public UserInfoData getUserInfosObject() {
        return this.objUserInfoData;
    }

    public void setSaveSuccess(boolean bSaveSuccess) {
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess() {
        return this.bSaveSuccess;
    }
}
