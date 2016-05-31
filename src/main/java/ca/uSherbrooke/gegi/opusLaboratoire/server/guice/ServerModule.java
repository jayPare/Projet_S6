/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusLaboratoire.server.guice;

import ca.uSherbrooke.gegi.opusLaboratoire.server.dispatch.DeleteUserActionHandler;
import ca.uSherbrooke.gegi.opusLaboratoire.shared.dispatch.DeleteUser;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(DeleteUser.class, DeleteUserActionHandler.class);
    }
}