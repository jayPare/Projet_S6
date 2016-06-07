package ca.uSherbrooke.gegi.opus.shared.entity;


import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;

import javax.persistence.*;

/**
 * Created by tomaslopinto on 01/06/16.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "get_all_stagiaires", // exists only for test purposes
                query = "SELECT first_name, last_name, departement_nom,numero_stage,concept_nom,niveau_sur_5_competence,niveau_sur_5_interet FROM release",
                resultClass = UserInfosData.class)
})


@Entity
@Table(name = "public.release", schema = "public", catalog = "opus")
public class UserInfosData implements Data {
    private String firstName;
    private String lastName;
    private String departementNom;
    private int numeroStage;
    private String conceptNom;
    private int niveauSur5Competence;
    private int niveauSur5Interet;

    //TODO
    // Compétences-CompetenceNiveaeuSur5 doit être une liste parce qu'il peut y avoir plusieurs compétences
    // Manque InteretNom
    // Interet-InteretNiveauSur5 doit être une liste parce qu'il peut y avoir plusieurs intérêts

    public UserInfosData(String firstName, String lastName, String departementNom, int numeroStage, int niveauSur5Competence, String conceptNom, int niveauSur5Interet, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departementNom = departementNom;
        this.numeroStage = numeroStage;
        this.niveauSur5Competence = niveauSur5Competence;
        this.conceptNom = conceptNom;
        this.niveauSur5Interet = niveauSur5Interet;
        this.id = id;
    }

    public UserInfosData()
    {

    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "departement_nom")
    public String getDepartementNom() {
        return departementNom;
    }

    public void setDepartementNom(String departementNom) {
        this.departementNom = departementNom;
    }

    @Basic
    @Column(name = "numero_stage")
    public int getNumeroStage() {
        return numeroStage;
    }

    public void setNumeroStage(int numeroStage) {
        this.numeroStage = numeroStage;
    }

    @Basic
    @Column(name = "concept_nom")
    public String getConceptNom() {
        return conceptNom;
    }

    public void setConceptNom(String conceptNom) {
        this.conceptNom = conceptNom;
    }

    @Id
    @Basic
    @Column(name = "niveau_sur_5_competence")
    public int getNiveauSur5Competence() {
        return niveauSur5Competence;
    }

    public void setNiveauSur5Competence(int niveauSur5Competence) {
        this.niveauSur5Competence = niveauSur5Competence;
    }

    @Basic
    @Column(name = "niveau_sur_5_interet")
    public int getNiveauSur5Interet() {
        return niveauSur5Interet;
    }

    public void setNiveauSur5Interet(int niveauSur5Interet) {
        this.niveauSur5Interet = niveauSur5Interet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfosData that = (UserInfosData) o;

        if (numeroStage != that.numeroStage) return false;
        if (niveauSur5Competence != that.niveauSur5Competence) return false;
        if (niveauSur5Interet != that.niveauSur5Interet) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (departementNom != null ? !departementNom.equals(that.departementNom) : that.departementNom != null)
            return false;
        if (conceptNom != null ? !conceptNom.equals(that.conceptNom) : that.conceptNom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (departementNom != null ? departementNom.hashCode() : 0);
        result = 31 * result + numeroStage;
        result = 31 * result + (conceptNom != null ? conceptNom.hashCode() : 0);
        result = 31 * result + niveauSur5Competence;
        result = 31 * result + niveauSur5Interet;
        return result;
    }

    public void setUserId(Integer userId)
    {
    };

    public Integer getUserId(){return null;};

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