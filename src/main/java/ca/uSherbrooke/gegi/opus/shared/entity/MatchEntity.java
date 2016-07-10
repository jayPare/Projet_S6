package ca.uSherbrooke.gegi.opus.shared.entity;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 10/07/16.
 */
@Entity
@Table(name = "match", schema = "recrusimple", catalog = "opus")
@IdClass(MatchEntityPK.class)
public class MatchEntity {
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

        MatchEntity that = (MatchEntity) o;

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
}
