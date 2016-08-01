package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by Fabul on 2016-07-21.
 */
public class CurrentUserInfo extends ActionImpl<CurrentUserInfoResult>
{
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

    public CurrentUserInfo()
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

