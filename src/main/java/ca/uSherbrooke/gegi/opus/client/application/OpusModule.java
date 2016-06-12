/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.opus.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OpusModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
    }
}