/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.place;

import com.gwtplatform.mvp.client.annotations.NameToken;

public class NameTokens
{
    public static final String MATCHES = "/matches";
    public static final String ETUDIANT_EDIT = "/editEtudiant";
    public static final String EMPLOYEUR_EDIT = "/editEmployeur";
    public static final String EMPLOYEUR = "/homeEmployeur";
    public static final String home = "/homeEtudiant";

    public static String getHome()
    {
        return home;
    }
}