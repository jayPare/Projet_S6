/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.employer.consultStudent;

import ca.uSherbrooke.gegi.opus.client.application.common.sideMenu.SideMenuModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class consultStudentModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new SideMenuModule());

        bindPresenter(consultStudentPagePresenter.class, consultStudentPagePresenter.MyView.class, consultStudentPageView.class,
                consultStudentPagePresenter.MyProxy.class);
    }
}