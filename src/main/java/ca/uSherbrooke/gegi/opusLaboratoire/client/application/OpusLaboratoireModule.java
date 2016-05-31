/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusLaboratoire.client.application;

import ca.uSherbrooke.gegi.opusLaboratoire.client.application.editUser.EditUserModule;
import ca.uSherbrooke.gegi.opusLaboratoire.client.application.home.HomeModule;
import ca.uSherbrooke.gegi.opusLaboratoire.client.application.home.user.UserModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OpusLaboratoireModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new UserModule());
        install(new EditUserModule());
    }
}