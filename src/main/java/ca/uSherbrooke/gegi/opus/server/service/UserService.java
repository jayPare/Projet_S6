package ca.uSherbrooke.gegi.opus.server.service;
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.commons.core.shared.utils.UserSessionActionException;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.setUserInfos;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import ca.uSherbrooke.gegi.persist.dao.Opus;
import com.google.inject.Inject;

import javax.persistence.EntityManager;
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

    public boolean insertUserInfos(GetUserInfos user) throws UserSessionActionException {
        this.dao.getEntityManager().createNamedQuery("save_user")
                .setParameter("stageNumber", user.m_nNumeroStage)
                .setParameter("stagiaireCV", user.m_strCV)
                .setParameter("strCIP", user.m_strCIP)
                .setParameter("deptID", user.m_nDepartementID).executeUpdate();
        user.setStagiaireID((int) this.dao.getNamedSingleResult("get_last_id"));
        setConcepts(user);
        return true;
    }

    public boolean updateUserInfos(GetUserInfos user) throws UserSessionActionException {
        this.dao.getEntityManager().createNamedQuery("update_user")
                .setParameter("stageNumber", user.m_nNumeroStage)
                .setParameter("stagiaireCV", user.m_strCV)
                .setParameter("strCIP", user.m_strCIP)
                .setParameter("deptID", user.m_nDepartementID)
                .setParameter("stagiaireID", user.getStagiaireID()).executeUpdate();
        setConcepts(user);
        return true;
    }

    public UserInfosData getUserInfos(GetUserInfos user) throws UserSessionActionException {
        UserInfosData objResult = (UserInfosData) (this.dao.getEntityManager().createNamedQuery("get_user")
                .setParameter("stagiaireID", user.getStagiaireID()).getSingleResult());
        objResult.setCompetence((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID", user.getStagiaireID()).getResultList());
        objResult.setInteret((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID", user.getStagiaireID()).getResultList());
        return objResult;
    }

    public UserInfosData getUserInfosWithCIP(GetUserInfos user) throws UserSessionActionException {
        UserInfosData objResult = (UserInfosData) (this.dao.getEntityManager().createNamedQuery("get_user_with_cip")
                .setParameter("strCIP", user.m_strCIP).getSingleResult());
        objResult.setCompetence((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID", objResult.getStagiaireID()).getResultList());
        objResult.setInteret((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID", objResult.getStagiaireID()).getResultList());
        return objResult;
    }

    public UserInfosData getNextUserInfos(GetUserInfos user) throws UserSessionActionException {
        UserInfosData objResult = (UserInfosData) (this.dao.getEntityManager().createNamedQuery("get_next_user")
                .setParameter("stagiaireID", user.getStagiaireID()).getSingleResult());
        objResult.setCompetence((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID", user.getStagiaireID()).getResultList());
        objResult.setInteret((List<ConceptData>) this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID", user.getStagiaireID()).getResultList());
        return objResult;
    }

    public boolean insertEmployerInfos(GetEmployerInfos employer) throws UserSessionActionException {
        this.dao.getEntityManager().createNamedQuery("save_employer")
                .setParameter("userID", employer.m_nUserID)
                .setParameter("name", employer.m_strName)
                .setParameter("domain", employer.m_strDomain)
                .setParameter("location", employer.m_strLocation)
                .setParameter("summary", employer.m_strSummary).executeUpdate();
        return true;
    }

    public boolean updateEmployerInfos(GetEmployerInfos employer) throws UserSessionActionException {
        this.dao.getEntityManager().createNamedQuery("update_employer")
                .setParameter("userID", employer.m_nUserID)
                .setParameter("name", employer.m_strName)
                .setParameter("domain", employer.m_strDomain)
                .setParameter("location", employer.m_strLocation)
                .setParameter("summary", employer.m_strSummary)
                .setParameter("employerID", employer.getEmployerID()).executeUpdate();
        return true;
    }

    public EmployerData getEmployerInfos(GetEmployerInfos employer) throws UserSessionActionException {
        EmployerData objResult = (EmployerData) (this.dao.getEntityManager().createNamedQuery("get_employer")
                .setParameter("employerID", employer.getEmployerID()).getSingleResult());
        return objResult;
    }

    public EmployerData getNextEmployerInfos(GetEmployerInfos employer) throws UserSessionActionException {
        EmployerData objResult = (EmployerData) (this.dao.getEntityManager().createNamedQuery("get_next_employer")
                .setParameter("employerID", employer.getEmployerID()).getSingleResult());
        return objResult;
    }

    public List<MatchData> getMatchEmployer(MatchInfos match) throws UserSessionActionException {
        List<MatchData> objResult = (List<MatchData>)(this.dao.getEntityManager().createNamedQuery("get_match_employer")
                .setParameter("employerID", match.getEmployerID()).getResultList());
        return objResult;
    }

    public List<MatchData> getMatchStagiaire(MatchInfos match) throws UserSessionActionException {
        List<MatchData> objResult = (List<MatchData>)(this.dao.getEntityManager().createNamedQuery("get_match_stagiaire")
                .setParameter("stagiaireID", match.getStagiaireID()).getResultList());
        return objResult;
    }

    public boolean saveMatchStagiaire(MatchInfos match) throws UserSessionActionException {
        this.dao.getEntityManager().createNamedQuery("save_match_employer")
                .setParameter("stagiaireID", match.getStagiaireID())
                .setParameter("employerID", match.getEmployerID())
                .setParameter("interet", match.getInteret()).executeUpdate();
        return true;
    }

    public boolean saveMatchEmployer(MatchInfos match) throws UserSessionActionException {
        this.dao.getEntityManager().createNamedQuery("save_match_stagiaire")
                .setParameter("stagiaireID", match.getStagiaireID())
                .setParameter("employerID", match.getEmployerID())
                .setParameter("interet", match.getInteret()).executeUpdate();
        return true;
    }

    public void setConcepts(GetUserInfos user) {
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
