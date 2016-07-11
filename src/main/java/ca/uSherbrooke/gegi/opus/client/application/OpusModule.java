/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur.EditProfileEmployeurModule;
import ca.uSherbrooke.gegi.opus.client.application.homeEmployeur.HomeEmployeurModule;
import ca.uSherbrooke.gegi.opus.client.application.homeEtudiant.HomeEtudiantModule;
import ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant.EditProfileEtudiantModule;
import ca.uSherbrooke.gegi.opus.client.application.inscriptionEmployeur.InscriptionEmployeurModule;
import ca.uSherbrooke.gegi.opus.client.application.viewMatches.ViewMatchesModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OpusModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        install(new HomeEtudiantModule());
        install(new HomeEmployeurModule());
        install(new EditProfileEtudiantModule());
        install(new InscriptionEmployeurModule());
        install(new EditProfileEmployeurModule());
        install(new ViewMatchesModule());
    }
}