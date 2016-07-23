package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomaslopinto on 20/06/16.
 */


@NamedNativeQueries({
        @NamedNativeQuery(name = "save_employer",
                query = "INSERT INTO recrusimple.employeur (administrative_user_id, nom,domaine,lieu,sommaire,taches) " +
                        "VALUES (#strCIP," +
                        "        #name," +
                        "        #domain," +
                        "        #location," +
                        "        #summary," +
                        "        #tasks)"),
        @NamedNativeQuery(name = "update_employer",
                query = "UPDATE recrusimple.employeur " +
                        "SET administrative_user_id = #strCIP," +
                        "    nom = #name," +
                        "    domaine = #domain," +
                        "    lieu = #location," +
                        "    sommaire = #summary," +
                        "    taches = #tasks " +
                        "WHERE employeur_id = #employerID"),
        @NamedNativeQuery(name = "get_employer",
                query = "SELECT * " +
                        "FROM recrusimple.employeur " +
                        "WHERE employeur_id = #employerID",
                resultClass = EmployerData.class),
        @NamedNativeQuery(name = "get_employer_with_cip",
                query = "SELECT * " +
                        "FROM recrusimple.employeur " +
                        "WHERE administrative_user_id = #strCIP",
                resultClass = EmployerData.class),
        @NamedNativeQuery(name = "get_next_employer",
                query = "SELECT * " +
                        "FROM recrusimple.employeur AS emp " +
                        "LEFT JOIN public.users AS U ON emp.administrative_user_id = U.administrative_user_id " +
                        "WHERE NOT EXISTS " +
                        "    (SELECT 1 " +
                        "     FROM recrusimple.stagiaire_interesse_par_employeur AS EIS " +
                        "     WHERE emp.employeur_id = EIS.employeur_id) LIMIT 1",
                resultClass = EmployerData.class)
})

@Entity
@Table(name = "recrusimple.employeur", schema = "recrusimple.", catalog = "opus")
@SecondaryTable(name = "recrusimple.concept_employeur",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "employeur_id"))
public class EmployerData implements Data {
    private int nEmployerId;
    private String strCIP;
    private String strName;
    private String strDomain;
    private String strAddress;
    private String strSummary;
    private String strTasks;
    public List<ConceptData> listStrTechnologies;

    @Id
    @Basic
    @Column(name = "employeur_id")
    public int getEmployerId() {
        return nEmployerId;
    }

    public void setEmployerId(int nEmployerId) {
        this.nEmployerId = nEmployerId;
    }

    @Basic
    @Column(name = "administrative_user_id")
    public String getCIP() {
        return strCIP;
    }

    public void setCIP(String strCIP) {
        this.strCIP = strCIP;
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

    @Basic
    @Column(name = "taches")
    public String getNature() {
        return strTasks;
    }

    public void setTasks(String strTasks) {
        this.strTasks = strTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployerData that = (EmployerData) o;

        if (nEmployerId != that.nEmployerId) return false;
        if (strName != null ? !strName.equals(that.strName) : that.strName != null)
            return false;
        if (strCIP != null ? !strCIP.equals(that.strCIP) : that.strCIP != null)
            return false;
        if (strDomain != null ? !strDomain.equals(that.strDomain) : that.strDomain != null)
            return false;
        if (strAddress != null ? !strAddress.equals(that.strAddress) : that.strAddress != null)
            return false;
        if (strSummary != null ? !strSummary.equals(that.strSummary) : that.strSummary != null)
            return false;
        if (strTasks != null ? !strTasks.equals(that.strTasks) : that.strTasks != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nEmployerId;
        result = 31 * result + (strCIP != null ? strCIP.hashCode() : 0);
        result = 31 * result + (strName != null ? strName.hashCode() : 0);
        result = 31 * result + (strDomain != null ? strDomain.hashCode() : 0);
        result = 31 * result + (strAddress != null ? strAddress.hashCode() : 0);
        result = 31 * result + (strSummary != null ? strSummary.hashCode() : 0);
        result = 31 * result + (strTasks != null ? strTasks.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return null;
    }

    public void setId(Integer nId) {
    }

    @Override
    public void setUserId(Integer integer) {
    }

    @Override
    public Integer getUserId() {
        return null;
    }

    public String getLabel() {
        return "";
    }

    public void setLabel(String strLabel) {
    }

    private String id;

    public void setId(String id) {
        this.id = id;
    }

}
