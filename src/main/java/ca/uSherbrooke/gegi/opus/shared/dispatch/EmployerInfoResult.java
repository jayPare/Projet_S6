package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-06-20.
 */
public class EmployerInfoResult implements Result {

    private EmployerData objEmployerInfoData;
    private List<EmployerData> m_objListEmployerInfoData; //-> only will be filled if you do a getAllEmployer
    private boolean bSaveSuccess = false;

    public EmployerInfoResult() {
    }

    public EmployerInfoResult(EmployerData objEmployerInfoData) {
        this.objEmployerInfoData = objEmployerInfoData;
    }

    public void setEmployerInfosObject(EmployerData objEmployerInfoData) {
        this.objEmployerInfoData = objEmployerInfoData;
    }

    public EmployerData getEmployerInfosObject() {
        return this.objEmployerInfoData;
    }

    public void setEmployerInfosListObject(List<EmployerData> objListEmployerInfoData) {
        this.m_objListEmployerInfoData = objListEmployerInfoData;
    }

    public List<EmployerData> getEmployerInfosListObject() {
        return this.m_objListEmployerInfoData;
    }

    public void setSaveSuccess(boolean bSaveSuccess){
        this.bSaveSuccess = bSaveSuccess;
    }

    public boolean getSaveSuccess(){
        return this.bSaveSuccess;
    }

}
