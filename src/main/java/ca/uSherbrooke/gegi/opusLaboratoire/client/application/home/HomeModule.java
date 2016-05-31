/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusLaboratoire.client.application.home;

import ca.uSherbrooke.gegi.opusLaboratoire.client.application.home.sideMenu.SideMenuModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new SideMenuModule());

        bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
                HomePagePresenter.MyProxy.class);
    }
}