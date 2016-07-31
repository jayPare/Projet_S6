package ca.uSherbrooke.gegi.opus.client.application.employer.consultStudent;/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */


import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Created by maip2202 on 2016-05-04.
 */
public interface consultStudentPageUiHandlers extends UiHandlers {
    public void actionOnLike(int nStagiaireID, int employerID);
    public void actionOnDislike(int nStagiaireID, int employerID);
    public void actionOnRefresh();
    public void setPresenterEmployerID(int employerID);
}
