package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;

import javax.persistence.*;

/**
 * Created by Fabul on 2016-06-11.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "get_competences",
                query = " SELECT C.concept_id, C.concept_nom, CCS.niveau_sur_5 FROM recrusimple.concept AS C " +
                        " LEFT JOIN recrusimple.concept_competence_stagiaire AS CCS ON C.concept_id = CCS.concept_id " +
                        " WHERE CCS.stagiaire_id = #stagiaireID ",
                resultClass = ConceptData.class),
        @NamedNativeQuery(name = "delete_competences",
                query = "DELETE " +
                        "FROM recrusimple.concept_competence_stagiaire " +
                        "WHERE stagiaire_id <> #stagiaireID"),
        @NamedNativeQuery(name = "save_competence",
                query = "INSERT INTO recrusimple.concept_competence_stagiaire (stagiaire_id, niveau_sur_5,concept_id) " +
                        "VALUES (#stagiaireID," +
                        "        #niveau5," +
                        "        #conceptID)"),
        @NamedNativeQuery(name = "get_interets",
                query = " SELECT C.concept_id, C.concept_nom, CIS.niveau_sur_5 FROM recrusimple.concept AS C " +
                        " LEFT JOIN recrusimple.concept_interet_stagiaire AS CIS ON C.concept_id = CIS.concept_id " +
                        " WHERE CIS.stagiaire_id = #stagiaireID ",
                resultClass = ConceptData.class),
        @NamedNativeQuery(name = "delete_interets",
                query = "DELETE " +
                        "FROM recrusimple.concept_interet_stagiaire " +
                        "WHERE stagiaire_id <> #stagiaireID"),
        @NamedNativeQuery(name = "save_interet",
                query = "INSERT INTO recrusimple.concept_interet_stagiaire (stagiaire_id,niveau_sur_5, concept_id) " +
                        "VALUES (#stagiaireID," +
                        "        #niveau5," +
                        "        #conceptID)"),
        @NamedNativeQuery(name = "get_employer_technologies",
                query = "SELECT C.concept_nom, C.concept_id " +
                        "FROM recrusimple.concept_employeur AS CE " +
                        "LEFT JOIN recrusimple.concept AS C on CE.concept_id = C.concept_id  " +
                        "WHERE employeur_id = #employerID",
                resultClass = ConceptData.class),
})

@Entity
@Table(name = "recrusimple.concept", schema = "recrusimple", catalog = "opus")
@SecondaryTables({
        @SecondaryTable(name = "recrusimple.concept_competence_stagiaire",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "concept_id")),
        @SecondaryTable(name = "recrusimple.concept_interet_stagiaire",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "concept_id")),
        @SecondaryTable(name = "recrusimple.concept_employeur",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "concept_id"))
})
public class ConceptData implements Data {
    String conceptNom = "";
    int niveauSur5 = 0;
    private int conceptID = 0;

    public ConceptData(String conceptNom, int niveauSur5, String id) {
        this.conceptNom = conceptNom;
        this.niveauSur5 = niveauSur5;
        this.id = id;
    }

    public ConceptData() {

    }

    @Id
    @Basic
    @Column(name = "concept_id")
    public int getConceptID() {
        return conceptID;
    }

    public void setConceptID(int conceptID) {
        this.conceptID = conceptID;
    }

    @Basic
    @Column(name = "concept_nom")
    public String getConceptNom() {
        return conceptNom;
    }

    public void setConceptNom(String conceptNom) {
        this.conceptNom = conceptNom;
    }

    @Basic
    @Column(name = "niveau_sur_5")
    public int getNiveauSur5() {
        return niveauSur5;
    }

    public void setNiveauSur5(int niveauSur5) {
        this.niveauSur5 = niveauSur5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConceptData that = (ConceptData) o;

        if (conceptNom != that.conceptNom) return false;
        if (niveauSur5 != that.niveauSur5) return false;
        if (conceptID != that.conceptID) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = conceptNom != null ? conceptNom.hashCode() : 0;
        result = 31 * result + niveauSur5;
        result = 31 * result + conceptID;
        return result;
    }

    public void setUserId(Integer userId) {
    }

    ;

    public Integer getUserId() {
        return null;
    }

    ;

    public Integer getId() {
        return null;
    }

    ;

    public void setId(Integer nId) {
    }

    public String getLabel() {
        return "";
    }

    ;

    public void setLabel(String strLabel) {
    }

    ;

    private String id;

    public void setId(String id) {
        this.id = id;
    }
}