package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomaslopinto on 20/06/16.
 */


@NamedNativeQueries({
        @NamedNativeQuery(name = "get_employer_with_cip",
                query = "SELECT employeur_id, administrative_user_id " +
                        "FROM recrusimple.employeur " +
                        "WHERE administrative_user_id = #strCIP",
                resultClass = GatekeeperData.class),
        @NamedNativeQuery(name = "get_stagiaire_with_cip",
                query = "SELECT stagiaire_id, administrative_user_id " +
                        "FROM recrusimple.stagiaire " +
                        "WHERE administrative_user_id = #strCIP",
                resultClass = GatekeeperData.class)
})

@Entity
@Table(name = "recrusimple.gatekeeper_view", schema = "recrusimple.", catalog = "opus")
public class GatekeeperData implements Data {
    private int nEmployerId = -1;
    private int nStagiaireId = -1;
    private String strCIP;

    @Id
    @Basic
    @Column(name = "employeur_id")
    public int getEmployerId() {
        return nEmployerId;
    }

    public void setEmployerId(int nEmployerId) {
        this.nEmployerId = nEmployerId;
    }

    @Id
    @Basic
    @Column(name = "stagiaire_id")
    public int getStagiaireId() {
        return nStagiaireId;
    }

    public void setStagiaireId(int nStagiaireId) {
        this.nStagiaireId = nStagiaireId;
    }


    @Basic
    @Column(name = "administrative_user_id")
    public String getCIP() {
        return strCIP;
    }

    public void setCIP(String strCIP) {
        this.strCIP = strCIP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GatekeeperData that = (GatekeeperData) o;

        if (nEmployerId != that.nEmployerId) return false;
        if (nStagiaireId != that.nStagiaireId) return false;
        if (strCIP != null ? !strCIP.equals(that.strCIP) : that.strCIP != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = nEmployerId;
        result = result + nStagiaireId;
        result = 31 * result + (strCIP != null ? strCIP.hashCode() : 0);
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
