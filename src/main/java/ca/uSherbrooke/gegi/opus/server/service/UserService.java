package ca.uSherbrooke.gegi.opus.server.service;
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.commons.core.shared.utils.UserSessionActionException;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.setUserInfos;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
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

    public UserInfosData getUserInfos(GetUserInfos action) throws UserSessionActionException{
        UserInfosData objResult;

        objResult = (UserInfosData)this.dao.getNamedSingleResult("set_stagiaire_infos");

        this.dao.getEntityManager().createNamedQuery("set_stagiaire_infos").setParameter("stagiaireID",3384).getResultList();



        objResult = (UserInfosData)this.dao.getNamedSingleResult("get_all_stagiaires");

        //INSERT INTO recrusimple.departement (departement_id, departement_nom) VALUES ('44', 'oui') ON CONFLICT ( departement_id ) DO UPDATE SET departement_nom = '44';

        objResult.setCompetence((List<ConceptData>)this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID",objResult.getStagiaireID()).getResultList());

        objResult.setInteret((List<ConceptData>)this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID",objResult.getStagiaireID()).getResultList());
        return objResult;
    }

    public EmployerData getEmployerInfos(GetEmployerInfos action) throws UserSessionActionException{
        EmployerData objResult;
        objResult = (EmployerData)this.dao.getNamedSingleResult("get_all_recruteur");
        return objResult;
    }


    public UserInfosData setUserInfos(setUserInfos action) throws UserSessionActionException{
        UserInfosData objResult;
        objResult = (UserInfosData)this.dao.getNamedSingleResult("insert_test");
        return objResult;
    }



}
