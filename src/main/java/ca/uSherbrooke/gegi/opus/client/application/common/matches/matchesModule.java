/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.common.matches;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class matchesModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        bindPresenter(matchesPagePresenter.class, matchesPagePresenter.MyView.class, matchesPageView.class, matchesPagePresenter.MyProxy.class);
    }
}