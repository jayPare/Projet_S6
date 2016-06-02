package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-05-31.
 */

@SuppressWarnings("serial")
public class GetUserInfosResult implements Result {

    private List<UserInfosData> objListUserInfoData;

    public GetUserInfosResult() {
    }

    public GetUserInfosResult(List<UserInfosData> objListUserInfoData) {
        this.objListUserInfoData = objListUserInfoData;
    }

    public void setUserInfosObject(List<UserInfosData> objListUserInfoData) {
        this.objListUserInfoData = objListUserInfoData;
    }

    public List<UserInfosData> getUserInfosObject() {
        return this.objListUserInfoData;
    }

}
