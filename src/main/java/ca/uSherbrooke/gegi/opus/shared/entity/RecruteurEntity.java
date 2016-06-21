package ca.uSherbrooke.gegi.opus.shared.entity;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 20/06/16.
 */



@NamedNativeQueries({
        @NamedNativeQuery(name = "get_all_recruteur", // exists only for test purposes
                query = "SELECT * FROM public.recruteur LIMIT 1",
                resultClass = RecruteurEntity.class)
})


@Entity
@Table(name = "recruteur", schema = "public", catalog = "opus")
public class RecruteurEntity {
    private int recruteurId;
    private String entrepriseSommaire;
    private String entrepriseNature;
    private String entrepriseFonction;
    private String entrepriseTechnologies;
    private String entrepriseExigences;




    @Id
    @Column(name = "recruteur_id")
    public int getRecruteurId() {
        return recruteurId;
    }

    public void setRecruteurId(int recruteurId) {
        this.recruteurId = recruteurId;
    }

    @Basic
    @Column(name = "entreprise_sommaire")
    public String getEntrepriseSommaire() {
        return entrepriseSommaire;
    }

    public void setEntrepriseSommaire(String entrepriseSommaire) {
        this.entrepriseSommaire = entrepriseSommaire;
    }

    @Basic
    @Column(name = "entreprise_nature")
    public String getEntrepriseNature() {
        return entrepriseNature;
    }

    public void setEntrepriseNature(String entrepriseNature) {
        this.entrepriseNature = entrepriseNature;
    }

    @Basic
    @Column(name = "entreprise_fonction")
    public String getEntrepriseFonction() {
        return entrepriseFonction;
    }

    public void setEntrepriseFonction(String entrepriseFonction) {
        this.entrepriseFonction = entrepriseFonction;
    }

    @Basic
    @Column(name = "entreprise_technologies")
    public String getEntrepriseTechnologies() {
        return entrepriseTechnologies;
    }

    public void setEntrepriseTechnologies(String entrepriseTechnologies) {
        this.entrepriseTechnologies = entrepriseTechnologies;
    }

    @Basic
    @Column(name = "entreprise_exigences")
    public String getEntrepriseExigences() {
        return entrepriseExigences;
    }

    public void setEntrepriseExigences(String entrepriseExigences) {
        this.entrepriseExigences = entrepriseExigences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecruteurEntity that = (RecruteurEntity) o;

        if (recruteurId != that.recruteurId) return false;
        if (entrepriseSommaire != null ? !entrepriseSommaire.equals(that.entrepriseSommaire) : that.entrepriseSommaire != null)
            return false;
        if (entrepriseNature != null ? !entrepriseNature.equals(that.entrepriseNature) : that.entrepriseNature != null)
            return false;
        if (entrepriseFonction != null ? !entrepriseFonction.equals(that.entrepriseFonction) : that.entrepriseFonction != null)
            return false;
        if (entrepriseTechnologies != null ? !entrepriseTechnologies.equals(that.entrepriseTechnologies) : that.entrepriseTechnologies != null)
            return false;
        if (entrepriseExigences != null ? !entrepriseExigences.equals(that.entrepriseExigences) : that.entrepriseExigences != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recruteurId;
        result = 31 * result + (entrepriseSommaire != null ? entrepriseSommaire.hashCode() : 0);
        result = 31 * result + (entrepriseNature != null ? entrepriseNature.hashCode() : 0);
        result = 31 * result + (entrepriseFonction != null ? entrepriseFonction.hashCode() : 0);
        result = 31 * result + (entrepriseTechnologies != null ? entrepriseTechnologies.hashCode() : 0);
        result = 31 * result + (entrepriseExigences != null ? entrepriseExigences.hashCode() : 0);
        return result;
    }
}
