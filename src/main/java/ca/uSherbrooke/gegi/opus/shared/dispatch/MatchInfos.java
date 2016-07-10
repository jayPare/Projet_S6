package ca.uSherbrooke.gegi.opus.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by Fabul on 2016-07-10.
 */
public class MatchInfos extends ActionImpl<MatchInfosResult> {
    private int m_nEmployerID = -1;
    private int m_nStagiaireID = -1;
    private boolean m_bInteret = false;
    private boolean m_bSaveStudentMatch = false;
    private boolean m_bSaveEmployerMatch = false;
    private boolean m_bGetMatchStudent = false;
    private boolean m_bGetMatchEmployer = false;

    public MatchInfos() {
    }

    public boolean getSaveStudentMatch() {
        return m_bSaveStudentMatch;
    }

    public boolean getSaveEmployerMatch() {
        return m_bSaveEmployerMatch;
    }

    public boolean getGetEmployerMatch() {
        return m_bGetMatchStudent;
    }

    public boolean getGetStagiaireMatch() {
        return m_bGetMatchEmployer;
    }

    public void setStagiaireID(int nStagiaireID) {
        this.m_nStagiaireID = nStagiaireID;
    }

    public int getStagiaireID() {
        return this.m_nStagiaireID;
    }

    public void setEmployerID(int nEmployerID) {
        this.m_nEmployerID = nEmployerID;
    }

    public int getEmployerID() {
        return this.m_nEmployerID;
    }

    public void setInteret(boolean bInteret) {
        this.m_bInteret = bInteret;
    }

    public boolean getInteret() {
        return this.m_bInteret;
    }

    public void saveStudentMatch(boolean bSaveStudentMatch, int nEmployerID, int nStagiaireID, boolean bInteret) {
        this.m_bSaveStudentMatch = bSaveStudentMatch;
        setEmployerID(nEmployerID);
        setStagiaireID(nStagiaireID);
        setInteret(bInteret);
    }

    public void saveEmployerMatch(boolean bSaveEmployerMatch, int nEmployerID, int nStagiaireID, boolean bInteret) {
        this.m_bSaveEmployerMatch = bSaveEmployerMatch;
        setEmployerID(nEmployerID);
        setStagiaireID(nStagiaireID);
        setInteret(bInteret);
    }

    public void getMatchStudent(int nStagiaireID, boolean bGetMatchStudent) {
        this.m_nStagiaireID = nStagiaireID;
        this.m_bGetMatchStudent = bGetMatchStudent;
    }

    public void getMatchEmployer(int nEmployerID, boolean bGetMatchEmployer) {
        this.m_nEmployerID = nEmployerID;
        this.m_bGetMatchEmployer = bGetMatchEmployer;
    }

    public boolean isSecured() {
        return false;
    }
}
