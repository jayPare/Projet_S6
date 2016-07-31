/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.place;

import com.gwtplatform.mvp.client.annotations.NameToken;

public class NameTokens
{
    public static final String MATCHES = "/matches";
    public static final String STUDENT_EDIT = "/studentEditProfile";
    public static final String EMPLOYER_EDIT = "/employerEditProfile";
    public static final String CONSULT_EMPLOYER = "/consultEmployer";
    public static final String CONSULT_STUDENT = "/consultStudent";

    public static String getHome()
    {
        return CONSULT_STUDENT;
    }
}