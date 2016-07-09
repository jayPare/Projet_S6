package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;

/**
 * Created by tomaslopinto on 07/07/16.
 */
public class setUserInfosResult {


    private UserInfosData objUserInfoData;
    private boolean bSaveSuccess = false;

    public setUserInfosResult() {
    }

    public setUserInfosResult(UserInfosData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public void setUserInfosObject(UserInfosData objUserInfoData) {
        this.objUserInfoData = objUserInfoData;
    }

    public UserInfosData setUserInfosObject() {
        return this.objUserInfoData;
    }

    public void setSaveSuccess(boolean bSaveSuccess){
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess(){
        return this.bSaveSuccess;
    }
}
