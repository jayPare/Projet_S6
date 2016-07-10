package ca.uSherbrooke.gegi.opus.shared.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tomaslopinto on 10/07/16.
 */
public class StagiaireInteresseParEmployeurEntityPK implements Serializable {
    private int stagiaireId;
    private int employeurId;

    @Column(name = "stagiaire_id")
    @Id
    public int getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(int stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    @Column(name = "employeur_id")
    @Id
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

        StagiaireInteresseParEmployeurEntityPK that = (StagiaireInteresseParEmployeurEntityPK) o;

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
