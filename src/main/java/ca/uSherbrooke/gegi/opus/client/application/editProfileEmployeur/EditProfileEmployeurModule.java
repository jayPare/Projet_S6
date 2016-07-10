/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur;

import ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur.sideMenu.SideMenuModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class EditProfileEmployeurModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new SideMenuModule());

        bindPresenter(EditProfileEmployeurPagePresenter.class, EditProfileEmployeurPagePresenter.MyView.class, EditProfileEmployeurPageView.class,
                EditProfileEmployeurPagePresenter.MyProxy.class);
    }
}