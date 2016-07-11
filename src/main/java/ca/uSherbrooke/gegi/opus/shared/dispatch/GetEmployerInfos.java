package ca.uSherbrooke.gegi.opus.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by Fabul on 2016-06-20.
 */
public class GetEmployerInfos extends ActionImpl<GetEmployerInfosResult> {
    private int m_nEmployerID = -1;
    //Set to true to save a new employer
    private boolean m_bSaveEmployer = false;
    //Set to true to update an existing employer with its employerID
    private boolean m_bUpdateEmployer = false;
    //Set to true to get a employer
    private boolean m_bGetEmployer = false;

    public String m_strName = "";
    public String m_strDomain = "";
    public String m_strLocation = "";
    public String m_strSummary = "";
    public String m_strCIP = "";

    public GetEmployerInfos() {
    }

    public boolean getSaveEmployer() {
        return m_bSaveEmployer;
    }

    public boolean getUpdateEmployer() {
        return m_bUpdateEmployer;
    }

    public boolean getGetEmployer() {
        return m_bGetEmployer;
    }

    public int getEmployerID() {
        return m_nEmployerID;
    }

    public void setEmployerID(int nEmployerID) {
        this.m_nEmployerID = nEmployerID;
    }

    public void insertNewEmployer(boolean bSaveEmployer) {
        this.m_bSaveEmployer = bSaveEmployer;
    }

    public void updateEmployer(int nEmployerID, boolean bUpdateEmployer) {
        this.m_nEmployerID = nEmployerID;
        this.m_bUpdateEmployer = bUpdateEmployer;
    }

    //Set nEmployerID to -1 to get a non-seen employer
    public void getEmployer(int nEmployerID, boolean bGetEmployer) {
        this.m_nEmployerID = nEmployerID;
        this.m_bGetEmployer = bGetEmployer;
    }
    public void getEmployerWithCIP(String strCIP, boolean bGetEmployer) {
        this.m_strCIP = strCIP;
        this.m_bGetEmployer = bGetEmployer;
    }

    public boolean isSecured() {
        return false;
    }
}
