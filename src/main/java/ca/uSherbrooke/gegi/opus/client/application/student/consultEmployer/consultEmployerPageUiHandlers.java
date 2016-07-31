package ca.uSherbrooke.gegi.opus.client.application.student.consultEmployer;/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */


import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Created by maip2202 on 2016-05-04.
 */
public interface consultEmployerPageUiHandlers extends UiHandlers {
    public void actionOnLike(int nEmployeurID);
    public void actionOnDislike(int nEmployeurID);
    public void actionOnRefresh();
}
