package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 20/06/16.
 */



@NamedNativeQueries({
        @NamedNativeQuery(name = "save_employer", // exists only for test purposes
                query = "INSERT INTO recrusimple.employeur (user_id, nom,domaine,lieu,sommaire,taches) " +
                        "VALUES (#userID," +
                        "        #name," +
                        "        #domain," +
                        "        #location," +
                        "        #summary," +
                        "        #tasks)"),
        @NamedNativeQuery(name = "update_employer", // exists only for test purposes
                query = "UPDATE recrusimple.employeur " +
                        "SET user_id = #userID," +
                        "    nom = #name," +
                        "    domaine = #domain," +
                        "    lieu = #location," +
                        "    sommaire = #summary," +
                        "    taches = #tasks " +
                        "WHERE employeur_id = #employerID"),
        @NamedNativeQuery(name = "get_employer", // exists only for test purposes
                query = "SELECT * " +
                        "FROM recrusimple.employeur " +
                        "WHERE employeur_id = #employerID",
                resultClass = EmployerData.class)
})


@Entity
@Table(name = "recrusimple.employeur", schema = "recrusimple.", catalog = "opus")
public class EmployerData implements Data {
    private int nEmployerId;
    private int nUserId;
    private String strName;
    private String strDomain;
    private String strAddress;
    private String strSummary;

    @Id
    @Basic
    @Column(name = "employeur_id")
    public int getEmployerId() {
        return nEmployerId;
    }

    public void setEmployerId(int nEmployerId) {
        this.nEmployerId = nEmployerId;
    }

    @Override
    public void setUserId(Integer integer) {

    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return nUserId;
    }

    public void setUserId(int nUserId) {
        this.nUserId = nUserId;
    }

    @Basic
    @Column(name = "nom")
    public String getEmployerName() {
        return strName;
    }

    public void setEmployerName(String strName) {
        this.strName = strName;
    }

    @Basic
    @Column(name = "sommaire")
    public String getEmployerSummary() {
        return strSummary;
    }

    public void setEmployerSummary(String strSummary) {
        this.strSummary = strSummary;
    }

    @Basic
    @Column(name = "domaine")
    public String getEmployerDomain() {
        return strDomain;
    }

    public void setEmployerDomain(String strDomain) {
        this.strDomain = strDomain;
    }

    @Basic
    @Column(name = "lieu")
    public String getEmployerAddress() {
        return strAddress;
    }

    public void setEmployerAddress(String strAddress) {
        this.strAddress = strAddress;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployerData that = (EmployerData) o;

        if (nEmployerId != that.nEmployerId) return false;
        if (nUserId != that.nUserId) return false;
        if (strName != null ? !strName.equals(that.strName) : that.strName != null)
            return false;
        if (strDomain != null ? !strDomain.equals(that.strDomain) : that.strDomain != null)
            return false;
        if (strAddress != null ? !strAddress.equals(that.strAddress) : that.strAddress != null)
            return false;
        if (strSummary != null ? !strSummary.equals(that.strSummary) : that.strSummary != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nEmployerId;
        result = result + nUserId;
        result = 31 * result + (strName != null ? strName.hashCode() : 0);
        result = 31 * result + (strDomain != null ? strDomain.hashCode() : 0);
        result = 31 * result + (strAddress != null ? strAddress.hashCode() : 0);
        result = 31 * result + (strSummary != null ? strSummary.hashCode() : 0);
        return result;
    }

    public Integer getId(){
        return null;
    };

    public void setId(Integer nId){}

    public String getLabel(){return "";};

    public void setLabel(String strLabel){};

    private String id;

    public void setId(String id) {
        this.id = id;
    }

}
