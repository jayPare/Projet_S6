package ca.uSherbrooke.gegi.opus.client.application.homeEtudiant;/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */


import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Created by maip2202 on 2016-05-04.
 */
public interface HomeEtudiantPageUiHandlers extends UiHandlers {
    public void actionOnLike(int nStagiaireID);
    public void actionOnDislike(int nStagiaireID);
    public void actionOnRefresh();
}
