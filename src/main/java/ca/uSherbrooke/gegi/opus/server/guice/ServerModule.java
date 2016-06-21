package ca.uSherbrooke.gegi.opus.server.guice;/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */


import ca.uSherbrooke.gegi.opus.server.dispatch.EmployerInfosActionHandler;
import ca.uSherbrooke.gegi.opus.server.dispatch.UserInfosActionHandler;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(GetEmployerInfos.class, EmployerInfosActionHandler.class);
        bindHandler(GetUserInfos.class, UserInfosActionHandler.class);
    }
}