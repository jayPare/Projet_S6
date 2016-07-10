/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.inscriptionEmployeur;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class InscriptionEmployeurModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        bindPresenter(InscriptionEmployeurPagePresenter.class, InscriptionEmployeurPagePresenter.MyView.class, InscriptionEmployeurPageView.class, InscriptionEmployeurPagePresenter.MyProxy.class);
    }
}