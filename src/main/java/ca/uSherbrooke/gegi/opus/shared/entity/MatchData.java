package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 10/07/16.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "get_match_employer",
                query = " SELECT * FROM recrusimple.view_match WHERE employeurID = #employeurID ",
                resultClass = MatchData.class),
        @NamedNativeQuery(name = "get_match_stagiaire",
                query = " SELECT * FROM recrusimple.view_match WHERE stagiaireID = #stagiaireID ",
                resultClass = MatchData.class)

        //TODO Add columns en bas
        //TODO Good select queries
})

@Entity
@Table(name = "recrusimple.view_match", schema = "recrusimple", catalog = "opus")
@IdClass(MatchDataPK.class)
public class MatchData implements Data {
    private int stagiaireId;
    private int employeurId;
    private String lastNameStudent;
    private String firstNameStudent;
    private String CIPStudent;
    private String emailStudent;
    private String phoneStudent;
    private String lastNameEmployer;
    private String firstNameEmployer;
    private String CIPEmployer;
    private String phoneEmployeur;

    private String emailEmployer;

    @Id
    @Column(name = "stagiaireID")
    public int getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(int stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    @Id
    @Column(name = "employeurID")
    public int getEmployeurId() {
        return employeurId;
    }

    public void setEmployeurId(int employeurId) {
        this.employeurId = employeurId;
    }

    @Column(name = "lastNameStudent")
    public String getLastNameStudent() {
        return lastNameStudent;
    }

    public void setLastNameStudent(String lastNameStudent) {
        this.lastNameStudent = lastNameStudent;
    }

    @Column(name = "firstNameStudent")
    public String getFirstNameStudent() {
        return firstNameStudent;
    }

    public void setFirstNameStudent(String firstNameStudent) {
        this.firstNameStudent = firstNameStudent;
    }

    @Column(name = "CIPStudent")
    public String getCIPStudent() {
        return CIPStudent;
    }

    public void setCIPStudent(String CIPStudent) {
        this.CIPStudent = CIPStudent;
    }

    @Column(name = "emailStudent")
    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    @Column(name = "phoneStudent")
    public String gePhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    @Column(name = "lastNameEmployer")
    public String getLastNameEmployer() {
        return lastNameEmployer;
    }

    public void setLastNameEmployer(String lastNameEmployer) {
        this.lastNameEmployer = lastNameEmployer;
    }

    @Column(name = "firstNameEmployer")
    public String getFirstNameEmployer() {
        return firstNameEmployer;
    }

    public void setFirstNameEmployer(String firstNameEmployer) {
        this.firstNameEmployer = firstNameEmployer;
    }

    @Column(name = "CIPEmployer")
    public String getCIPEmployer() {
        return CIPEmployer;
    }

    public void setCIPEmployer(String CIPEmployer) {
        this.CIPEmployer = CIPEmployer;
    }

    @Column(name = "emailEmployer")
    public String getEmailEmployer() {
        return emailEmployer;
    }

    public void setEmailEmployer(String emailEmployer) {
        this.emailEmployer = emailEmployer;
    }

    @Column(name = "phoneEmployeur")
    public String getPhoneEmployeur() {
        return phoneEmployeur;
    }

    public void setPhoneEmployeur(String phoneEmployeur) {
        this.phoneEmployeur = phoneEmployeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchData that = (MatchData) o;

        if (stagiaireId != that.stagiaireId) return false;
        if (employeurId != that.employeurId) return false;
        if (firstNameStudent != null ? !firstNameStudent.equals(that.firstNameStudent) : that.firstNameStudent != null) return false;
        if (lastNameStudent != null ? !lastNameStudent.equals(that.lastNameStudent) : that.lastNameStudent != null) return false;
        if (CIPStudent != null ? !CIPStudent.equals(that.CIPStudent) : that.CIPStudent != null) return false;
        if (emailStudent != null ? !emailStudent.equals(that.emailStudent) : that.emailStudent != null) return false;
        if (phoneStudent != null ? !phoneStudent.equals(that.phoneStudent) : that.phoneStudent != null) return false;
        if (firstNameEmployer != null ? !firstNameEmployer.equals(that.firstNameEmployer) : that.firstNameEmployer != null) return false;
        if (lastNameEmployer != null ? !lastNameEmployer.equals(that.lastNameEmployer) : that.lastNameEmployer != null) return false;
        if (CIPEmployer != null ? !CIPEmployer.equals(that.CIPEmployer) : that.CIPEmployer != null) return false;
        if (emailEmployer != null ? !emailEmployer.equals(that.emailEmployer) : that.emailEmployer != null) return false;
        if (phoneEmployeur != null ? !phoneEmployeur.equals(that.phoneEmployeur) : that.phoneEmployeur != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = stagiaireId;
        result = 31 * result + employeurId;
        result = 31 * result + (firstNameStudent != null ? firstNameStudent.hashCode() : 0);
        result = 31 * result + (lastNameStudent != null ? lastNameStudent.hashCode() : 0);
        result = 31 * result + (CIPStudent != null ? CIPStudent.hashCode() : 0);
        result = 31 * result + (emailStudent != null ? emailStudent.hashCode() : 0);
        result = 31 * result + (phoneStudent != null ? phoneStudent.hashCode() : 0);
        result = 31 * result + (firstNameEmployer != null ? firstNameEmployer.hashCode() : 0);
        result = 31 * result + (lastNameEmployer != null ? lastNameEmployer.hashCode() : 0);
        result = 31 * result + (CIPEmployer != null ? CIPEmployer.hashCode() : 0);
        result = 31 * result + (emailEmployer != null ? emailEmployer.hashCode() : 0);
        result = 31 * result + (phoneEmployeur != null ? phoneEmployeur.hashCode() : 0);
        return result;
    }

    public void setUserId(Integer userId) {
    }

    public Integer getUserId() {
        return null;
    }

    public Integer getId() {
        return null;
    }

    public void setId(Integer nId) {
    }

    public String getLabel() {
        return "";
    }

    public void setLabel(String strLabel) {
    }
}
