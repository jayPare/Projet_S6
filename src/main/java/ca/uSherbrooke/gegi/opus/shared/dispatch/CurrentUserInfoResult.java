package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
import com.gwtplatform.dispatch.rpc.shared.Result;

/**
 * Created by Fabul on 2016-07-21.
 */
public class CurrentUserInfoResult implements Result {

    //private boolean bSaveSuccess = false;

    private EmployerData m_objEmployer;
    private UserInfoData m_objUser;

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

    //public void setSaveSuccess(boolean bSaveSuccess) {
    //    this.bSaveSuccess = bSaveSuccess;
    //}

    //public boolean getSaveSuccess() {
    //    return this.bSaveSuccess;
    //}

    private int m_studentID = -1;
    private int m_employerID = -1;
    private String m_strCIP = "";

    public int getUserID()
    {
        if(m_studentID != -1)
            return m_studentID;
        else if(m_employerID != -1)
            return m_employerID;
        else
            return -1;
    }

    public CurrentUserInfoResult()
    {
    }

    public void setUserCIP(String strCIP) {
        this.m_strCIP = strCIP;
    }
    public String getUserCIP() {
        return this.m_strCIP;
    }
    public void setStudentID(int studentID) {
        this.m_studentID = studentID;
    }
    public void setEmployerID(int employerID) {
        this.m_employerID = employerID;
    }
    public int getStudentID() {
        return this.m_studentID;
    }
    public int getEmployerID() {
        return this.m_employerID;
    }

    public boolean isSecured() {
        return false;
    }

}
