/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEtudiant;

import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HomeEtudiantModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new SideMenuModule());

        bindPresenter(HomeEtudiantPagePresenter.class, HomeEtudiantPagePresenter.MyView.class, HomeEtudiantPageView.class,
                HomeEtudiantPagePresenter.MyProxy.class);
    }
}