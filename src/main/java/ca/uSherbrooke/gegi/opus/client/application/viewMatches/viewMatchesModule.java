/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.viewMatches;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ViewMatchesModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        bindPresenter(ViewMatchesPagePresenter.class, ViewMatchesPagePresenter.MyView.class, ViewMatchesPageView.class, ViewMatchesPagePresenter.MyProxy.class);
    }
}