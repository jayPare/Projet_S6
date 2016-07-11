package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 10/07/16.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "get_match_employer",
                query = "SELECT * " +
                        "FROM recrusimple.match " +
                        "WHERE employeur_id = #employerID",
                resultClass = MatchData.class),
        @NamedNativeQuery(name = "get_match_stagiaire",
                query = "SELECT * " +
                        "FROM recrusimple.match " +
                        "WHERE stagiaire_id = #stagiaireID",
                resultClass = MatchData.class)
})

@Entity
@Table(name = "match", schema = "recrusimple", catalog = "opus")
@IdClass(MatchDataPK.class)
public class MatchData implements Data {
    private int stagiaireId;
    private int employeurId;

    @Id
    @Column(name = "stagiaire_id")
    public int getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(int stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    @Id
    @Column(name = "employeur_id")
    public int getEmployeurId() {
        return employeurId;
    }

    public void setEmployeurId(int employeurId) {
        this.employeurId = employeurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchData that = (MatchData) o;

        if (stagiaireId != that.stagiaireId) return false;
        if (employeurId != that.employeurId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stagiaireId;
        result = 31 * result + employeurId;
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
