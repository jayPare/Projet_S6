/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant;

import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class EditProfileEtudiantModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(EditProfileEtudiantPagePresenter.class, EditProfileEtudiantPagePresenter.MyView.class, EditProfileEtudiantPageView.class,
                EditProfileEtudiantPagePresenter.MyProxy.class);
    }
}