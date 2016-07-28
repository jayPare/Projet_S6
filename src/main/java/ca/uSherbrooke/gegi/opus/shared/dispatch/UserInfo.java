package ca.uSherbrooke.gegi.opus.shared.dispatch;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

import java.util.List;

/**
 * Created by Fabul on 2016-05-31.
 */

public class UserInfo extends ActionImpl<UserInfoResult> {
    private int m_nStagiaireID = -1;
    private int m_nEmployerID = -1;
    //Set to true to save a new student
    private boolean m_bSaveStudent = false;
    //Set to true to update an existing student with its stagiaireID
    private boolean m_bUpdateStudent = false;
    //Set to true to get a student
    private boolean m_bGetStudent = false;
    //Set to true to get a new student
    private boolean m_bGetNextStudent = false;
    //Set to true to get all students
    private boolean m_bGetAllStudent = false;
    //Set to true to get all concepts
    private boolean m_bGetAllConcept = false;

    public String m_strFirstName = "";
    public String m_strLastName = "";
    public int m_nDepartementID = -1;
    public String m_strCV = "";
    public int m_nNumeroStage = -1;
    public String m_strCIP = "";
    public List<ConceptData> m_objListInteret = null;
    public List<ConceptData> m_objListCompetence = null;

    public UserInfo() {
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

    public boolean getGetNextStudent() {
        return m_bGetNextStudent;
    }

    public boolean getGetAllConcept() {
        return m_bGetAllConcept;
    }

    public boolean getGetAllStudents() {
        return m_bGetAllStudent;
    }

    public int getStagiaireID() {
        return m_nStagiaireID;
    }

    public int getEmployerID() {
        return m_nEmployerID;
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

    public void getStudent(int nStagiaireID, boolean bGetStudent) {
        this.m_nStagiaireID = nStagiaireID;
        this.m_bGetStudent = bGetStudent;
    }

    //get the next student for a specific employer
    public void getNextStudent(boolean bGetNextStudent, int employerID) {
        this.m_bGetNextStudent = bGetNextStudent;
        this.m_nEmployerID = employerID;
    }

    public void getAllStudent(boolean bGetAllStudent) {
        this.m_bGetAllStudent = bGetAllStudent;
    }

    public void getAllConcept(boolean bGetAllConcept) {
        this.m_bGetAllConcept = bGetAllConcept;
    }

    public void getStudentWithCIP(String strCIP, boolean bGetStudent) {
        this.m_strCIP = strCIP;
        this.m_bGetStudent = bGetStudent;
    }

    public boolean isSecured() {
        return false;
    }
}

