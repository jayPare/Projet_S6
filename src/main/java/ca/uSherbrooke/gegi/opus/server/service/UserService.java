package ca.uSherbrooke.gegi.opus.server.service;
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.commons.core.shared.utils.UserSessionActionException;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import ca.uSherbrooke.gegi.persist.dao.Opus;
import com.google.inject.Inject;

import java.util.ArrayList;
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
        UserInfosData listResult = new UserInfosData();
        listResult = (UserInfosData)this.dao.getNamedSingleResult("get_all_stagiaires");
        listResult.setCompetence((List<ConceptData>)this.dao.getEntityManager().createNamedQuery("get_competences").setParameter("stagiaireID",listResult.getStagiaireID()).getResultList());
        listResult.setInteret((List<ConceptData>)this.dao.getEntityManager().createNamedQuery("get_interets").setParameter("stagiaireID",listResult.getStagiaireID()).getResultList());
        return listResult;
    }
}
