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
    private List<UserInfoData> m_objListUserInfoData; //-> only will be filled if you do a getAllUser
    private boolean bSaveSuccess = false;

    public UserInfoResult() {
    }

    public UserInfoResult(UserInfoData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public void setUserInfosObject(UserInfoData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public void setUserInfosListObject(List<UserInfoData> objListUserInfoData) {
        this.m_objListUserInfoData = objListUserInfoData;
    }

    public UserInfoData getUserInfosObject() {
        return this.objUserInfoData;
    }

    public List<UserInfoData> getUserInfosListObject() {
        return this.m_objListUserInfoData;
    }

    public void setSaveSuccess(boolean bSaveSuccess) {
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess() {
        return this.bSaveSuccess;
    }
}
