package ca.uSherbrooke.gegi.opus.shared.entity;

import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Fabul on 2016-07-10.
 */
public class TestUserService {

    public static void main(String[] args) {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("opus");
        EntityManager entitymanager = emf.createEntityManager();

        UserInfo user = new UserInfo();

        user.m_nNumeroStage = 1;
        user.m_strCV = "asdasdasd";
        user.m_nUserID = 1;
        user.m_nDepartementID = 1;

        user.m_nNumeroStage = 1;
        user.m_nNumeroStage = 1;

        entitymanager.getTransaction().begin();
        entitymanager.createNamedQuery("save_user")
                .setParameter("stageNumber", user.m_nNumeroStage)
                .setParameter("stagiaireCV", user.m_strCV)
                .setParameter("userID", user.m_nUserID)
                .setParameter("deptID", user.m_nDepartementID).executeUpdate();
        user.setStagiaireID((int) this.dao.getNamedSingleResult("get_last_id"));
        entitymanager.createNamedQuery("delete_competences").executeUpdate(); // Only way to do that is to delete all entries first
        for (ConceptData concept : user.m_objListCompetence) {
            entitymanager.createNamedQuery("save_competence")
                    .setParameter("stagiaireID", user.getStagiaireID())
                    .setParameter("niveau_sur_5 ", concept.getNiveauSur5())
                    .setParameter("concept_id", concept.getConceptID()).executeUpdate();
        }
        entitymanager.createNamedQuery("delete_interets").executeUpdate(); // Only way to do that is to delete all entries first
        for (ConceptData concept : user.m_objListInteret) {
            entitymanager.createNamedQuery("save_interet")
                    .setParameter("stagiaireID", user.getStagiaireID())
                    .setParameter("niveau_sur_5 ", concept.getNiveauSur5())
                    .setParameter("concept_id", concept.getConceptID()).executeUpdate();
        }
        entitymanager.getTransaction().commit();*/
    }
}
