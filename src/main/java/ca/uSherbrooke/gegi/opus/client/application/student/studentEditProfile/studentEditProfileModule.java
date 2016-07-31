/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.student.studentEditProfile;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class studentEditProfileModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(studentEditProfilePagePagePresenter.class, studentEditProfilePagePagePresenter.MyView.class, studentEditProfilePageView.class,
                studentEditProfilePagePagePresenter.MyProxy.class);
    }
}