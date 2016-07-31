/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.opus.client.application.employer.employerEditProfile.employerEditProfileModule;
import ca.uSherbrooke.gegi.opus.client.application.student.consultEmployer.consultEmployerModule;
import ca.uSherbrooke.gegi.opus.client.application.employer.consultStudent.consultStudentModule;
import ca.uSherbrooke.gegi.opus.client.application.student.studentEditProfile.studentEditProfileModule;
import ca.uSherbrooke.gegi.opus.client.application.common.matches.matchesModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OpusModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        install(new consultStudentModule());
        install(new consultEmployerModule());
        install(new studentEditProfileModule());
        install(new employerEditProfileModule());
        install(new matchesModule());
    }
}