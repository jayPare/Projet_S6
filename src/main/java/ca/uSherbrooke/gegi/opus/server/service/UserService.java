package ca.uSherbrooke.gegi.opus.server.service;
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.commons.core.shared.utils.UserSessionActionException;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfo;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import ca.uSherbrooke.gegi.persist.dao.Opus;
import com.google.inject.Inject;

import java.util.List;

public class UserService {
    private UserSession userSession;
    @Opus
    private Dao dao;

    @Inject
    public UserService(UserSession userSession, @Opus Dao dao) {
        this.userSession = userSession;
        this.dao = dao;
    }

    public boolean insertUserInfos(UserInfo user) throws UserSessionActionException {
        try {
            this.dao.beginTransaction();
            this.dao.getEntityManager().createNamedQuery("save_user")
                    .setParameter("stageNumber", user.m_nNumeroStage)
                    .setParameter("stagiaireCV", user.m_strCV)
                    .setParameter("strCIP", user.m_strCIP)
                    .setParameter("deptID", user.m_nDepartementID).executeUpdate();
            user.setStagiaireID((int) this.dao.getNamedSingleResult("get_last_id"));
            setConcepts(user);
            this.dao.commitTransaction();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return true;
    }

    public boolean updateUserInfos(UserInfo user) throws UserSessionActionException {
        try {
            this.dao.beginTransaction();
            this.dao.getEntityManager().createNamedQuery("update_user")
                    .setParameter("stageNumber", user.m_nNumeroStage)
                    .setParameter("stagiaireCV", user.m_strCV)
                    .setParameter("strCIP", user.m_strCIP)
                    .setParameter("deptID", user.m_nDepartementID)
                    .setParameter("stagiaireID", user.getStagiaireID()).executeUpdate();
            setConcepts(user);
            this.dao.commitTransaction();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return true;
    }

    public UserInfoData getUserInfos(UserInfo user) throws UserSessionActionException {
        UserInfoData objResult = null;
        try {
            objResult = (UserInfoData) (this.dao.getEntityManager().createNamedQuery("get_user")
                    .setParameter("stagiaireID", user.getStagiaireID()).getSingleResult());
            objResult.setCompetence((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID", user.getStagiaireID()).getResultList());
            objResult.setInteret((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID", user.getStagiaireID()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public UserInfoData getUserInfosWithCIP(UserInfo user) throws UserSessionActionException {
        UserInfoData objResult = null;
        try {
            objResult = (UserInfoData) (this.dao.getEntityManager().createNamedQuery("get_user_with_cip")
                    .setParameter("strCIP", user.m_strCIP).getSingleResult());
            objResult.setCompetence((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID", objResult.getStagiaireID()).getResultList());
            objResult.setInteret((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID", objResult.getStagiaireID()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public UserInfoData getNextUserInfos(UserInfo user) throws UserSessionActionException {
        UserInfoData objResult = null;
        try {
            objResult = (UserInfoData) (this.dao.getEntityManager().createNamedQuery("get_next_user").getSingleResult());
            objResult.setCompetence((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID", objResult.getStagiaireID()).getResultList());
            objResult.setInteret((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID", objResult.getStagiaireID()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public boolean insertEmployerInfos(EmployerInfo employer) throws UserSessionActionException {
        try {
            this.dao.beginTransaction();
            this.dao.getEntityManager().createNamedQuery("save_employer")
                    .setParameter("strCIP", employer.m_strCIP)
                    .setParameter("name", employer.m_strName)
                    .setParameter("domain", employer.m_strDomain)
                    .setParameter("location", employer.m_strLocation)
                    .setParameter("summary", employer.m_strSummary).executeUpdate();
            this.dao.commitTransaction();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return true;
    }

    public boolean updateEmployerInfos(EmployerInfo employer) throws UserSessionActionException {
        try {
            this.dao.beginTransaction();
            this.dao.getEntityManager().createNamedQuery("update_employer")
                    .setParameter("strCIP", employer.m_strCIP)
                    .setParameter("name", employer.m_strName)
                    .setParameter("domain", employer.m_strDomain)
                    .setParameter("location", employer.m_strLocation)
                    .setParameter("summary", employer.m_strSummary)
                    .setParameter("employerID", employer.getEmployerID()).executeUpdate();
            this.dao.commitTransaction();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return true;
    }

    public EmployerData getEmployerInfos(EmployerInfo employer) throws UserSessionActionException {
        EmployerData objResult = null;
        try {
            objResult = (EmployerData) (this.dao.getEntityManager().createNamedQuery("get_employer")
                    .setParameter("employerID", employer.getEmployerID()).getSingleResult());
            objResult.setTechnologies((List<String>) this.dao.getEntityManager().createNamedQuery("get_employer_technologies").setParameter("employerID", employer.getEmployerID()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public EmployerData getEmployerInfosWithCIP(EmployerInfo employer) throws UserSessionActionException {
        EmployerData objResult = null;
        try {
            objResult = (EmployerData) (this.dao.getEntityManager().createNamedQuery("get_employer_with_cip")
                    .setParameter("strCIP", employer.m_strCIP).getSingleResult());
            objResult.setTechnologies((List<String>) this.dao.getEntityManager().createNamedQuery("get_employer_technologies").setParameter("employerID", objResult.getEmployerId()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public EmployerData getNextEmployerInfos(EmployerInfo employer) throws UserSessionActionException {
        EmployerData objResult = null;
        try {
            objResult = (EmployerData) (this.dao.getEntityManager().createNamedQuery("get_next_employer").getSingleResult());
            objResult.setTechnologies((List<String>) this.dao.getEntityManager().createNamedQuery("get_employer_technologies").setParameter("employerID", objResult.getEmployerId()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public List<MatchData> getMatchEmployer(MatchInfo match) throws UserSessionActionException {
        List<MatchData> objResult = null;
        try {
            objResult = (List<MatchData>) (this.dao.getEntityManager().createNamedQuery("get_match_employer")
                    .setParameter("employerID", match.getEmployerID()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public List<MatchData> getMatchStagiaire(MatchInfo match) throws UserSessionActionException {
        List<MatchData> objResult = null;
        try {
            objResult = (List<MatchData>) (this.dao.getEntityManager().createNamedQuery("get_match_stagiaire")
                    .setParameter("stagiaireID", match.getStagiaireID()).getResultList());
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return objResult;
    }

    public boolean saveMatchStagiaire(MatchInfo match) throws UserSessionActionException {
        try {
            this.dao.beginTransaction();
            this.dao.getEntityManager().createNamedQuery("save_match_stagiaire")
                    .setParameter("stagiaireID", match.getStagiaireID())
                    .setParameter("employerID", match.getEmployerID())
                    .setParameter("interet", match.getInteret()).executeUpdate();
            this.dao.commitTransaction();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return true;
    }

    public boolean saveMatchEmployer(MatchInfo match) throws UserSessionActionException {
        try {
            this.dao.beginTransaction();
            this.dao.getEntityManager().createNamedQuery("save_match_employer")
                    .setParameter("stagiaireID", match.getStagiaireID())
                    .setParameter("employerID", match.getEmployerID())
                    .setParameter("interet", match.getInteret()).executeUpdate();
            this.dao.commitTransaction();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            this.dao.rollbackTransaction();
            this.dao.clearEntityManager();
        }
        return true;
    }

    public void setConcepts(UserInfo user) {
        this.dao.getEntityManager().createNamedQuery("delete_competences").executeUpdate(); // Only way to do that is to delete all entries first
        for (ConceptData concept : user.m_objListCompetence) {
            this.dao.getEntityManager().createNamedQuery("save_competence")
                    .setParameter("stagiaireID", user.getStagiaireID())
                    .setParameter("niveau_sur_5 ", concept.getNiveauSur5())
                    .setParameter("concept_id", concept.getConceptID()).executeUpdate();
        }
        this.dao.getEntityManager().createNamedQuery("delete_interets").executeUpdate(); // Only way to do that is to delete all entries first
        for (ConceptData concept : user.m_objListInteret) {
            this.dao.getEntityManager().createNamedQuery("save_interet")
                    .setParameter("stagiaireID", user.getStagiaireID())
                    .setParameter("niveau_sur_5 ", concept.getNiveauSur5())
                    .setParameter("concept_id", concept.getConceptID()).executeUpdate();
        }
    }
}
