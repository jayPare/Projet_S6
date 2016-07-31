/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.student.consultEmployer;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class consultEmployerModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(consultEmployerPagePresenter.class, consultEmployerPagePresenter.MyView.class, consultEmployerPageView.class,
                consultEmployerPagePresenter.MyProxy.class);
    }
}