package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
import com.gwtplatform.dispatch.rpc.shared.Result;

/**
 * Created by Fabul on 2016-07-21.
 */
public class CurrentUserInfoResult implements Result {

    private boolean bSaveSuccess = false;

    private EmployerData m_objEmployer;
    private UserInfoData m_objUser;

    public CurrentUserInfoResult() {
    }

    public void setEmployerObject(EmployerData objEmployerInfo) {
        this.m_objEmployer = objEmployerInfo;
    }

    public void setUserObject(UserInfoData objUserInfo) {
        this.m_objUser = objUserInfo;
    }

    public EmployerData getEmployerObject() {
        return this.m_objEmployer;
    }
    public UserInfoData getUserObject() {
        return this.m_objUser;
    }

    public void setSaveSuccess(boolean bSaveSuccess) {
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess() {
        return this.bSaveSuccess;
    }

}
