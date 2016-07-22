package ca.uSherbrooke.gegi.opus.server.guice;/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */


import ca.uSherbrooke.gegi.opus.server.dispatch.EmployerInfoActionHandler;
import ca.uSherbrooke.gegi.opus.server.dispatch.GateKeeperActionHandler;
import ca.uSherbrooke.gegi.opus.server.dispatch.MatchInfoActionHandler;
import ca.uSherbrooke.gegi.opus.server.dispatch.UserInfoActionHandler;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GatekeeperInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfo;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(EmployerInfo.class, EmployerInfoActionHandler.class);
        bindHandler(UserInfo.class, UserInfoActionHandler.class);
        bindHandler(MatchInfo.class, MatchInfoActionHandler.class);
        bindHandler(GatekeeperInfo.class, GateKeeperActionHandler.class);
    }
}