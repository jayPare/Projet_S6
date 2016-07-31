/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.employer.employerEditProfile;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class employerEditProfileModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        bindPresenter(employerEditProfilePagePresenter.class, employerEditProfilePagePresenter.MyView.class, employerEditProfilePageView.class, employerEditProfilePagePresenter.MyProxy.class);
    }
}