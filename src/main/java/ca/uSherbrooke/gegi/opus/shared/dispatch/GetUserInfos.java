package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

import java.util.List;

/**
 * Created by Fabul on 2016-05-31.
 */

public class GetUserInfos extends ActionImpl<GetUserInfosResult> {
    private int m_nStagiaireID = -1;
    //Set to true to save a new student
    private boolean m_bSaveStudent = false;
    //Set to true to update an existing student with its stagiaireID
    private boolean m_bUpdateStudent = false;
    //Set to true to get a student
    private boolean m_bGetStudent = false;

    public String m_strFirstName = "";
    public String m_strLastName = "";
    public int m_nDepartementID = -1;
    public String m_strCV = "";
    public int m_nNumeroStage = -1;
    public int m_nUserID = -1;
    public List<ConceptData> m_objListInteret = null;
    public List<ConceptData> m_objListCompetence = null;

    public GetUserInfos() {
    }

    public boolean getSaveStudent() {
        return m_bSaveStudent;
    }

    public boolean getUpdateStudent() {
        return m_bUpdateStudent;
    }

    public boolean getGetStudent() {
        return m_bGetStudent;
    }

    public int getStagiaireID() {
        return m_nStagiaireID;
    }

    public void setStagiaireID(int nStagiaireID) {
        this.m_nStagiaireID = nStagiaireID;
    }

    public void insertNewStudent(boolean bSaveStudent) {
        this.m_bSaveStudent = bSaveStudent;
    }

    public void updateStudent(int nStagiaireID, boolean bUpdateStudent) {
        this.m_nStagiaireID = nStagiaireID;
        this.m_bUpdateStudent = bUpdateStudent;
    }

    //Set nStagiaireID to -1 to get a non-seen student
    public void getStudent(int nStagiaireID, boolean bGetStudent) {
        this.m_nStagiaireID = nStagiaireID;
        this.m_bGetStudent = bGetStudent;
    }

    public boolean isSecured() {
        return false;
    }
}

