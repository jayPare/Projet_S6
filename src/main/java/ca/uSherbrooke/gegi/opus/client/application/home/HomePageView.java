/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.home;

import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.FormLabel;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import java.util.List;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {

    private final Widget widget;

    @Override
    public void setUiHandlers(HomePageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, HomePageView> {
    }

    public interface checkUiHandlers extends UiHandlers {
        void onCheck();
    }
    @UiField
    FormLabel lblPrenom;
    @UiField
    FormLabel lblNom;
    @UiField
    FormLabel lblProgrammeEtude;
    @UiField
    FormLabel lblStage;
    @UiField
    FormLabel lblEcole;
    @UiField
    FormLabel lblCompetences;
    @UiField
    FormLabel lblInteretsObjectifs;
    @UiField
    Anchor anchorCheck;
    @UiField
    Anchor anchorClose;

    public void setUsersInfos(List<UserInfosData> objListUserInfos){

        lblPrenom.setText(objListUserInfos.get(0).getFirstName());
        lblNom.setText(objListUserInfos.get(0).getLastName());
        lblProgrammeEtude.setText(objListUserInfos.get(0).getDepartementNom());
        lblStage.setText(Integer.toString(objListUserInfos.get(0).getNumeroStage()));
        lblCompetences.setText(objListUserInfos.get(0).getConceptNom());
        lblInteretsObjectifs.setText(objListUserInfos.get(0).getDepartementNom());
        /*
         for (ReleaseEntity a : users ) {
            System.out.println("Prenom de la table user : "
                    +" prenom :"+ a.getFirstName()+" nom "+ a.getLastName()+ " departement "+ a.getDepartementNom()
                    +" num de stage "+ a.getNumeroStage() +"concept " + a.getConceptNom() + " competence " + a.getNiveauSur5Competence()
                    + " interet " + a.getNiveauSur5Interet() );
        }
         */
    }

    @UiHandler("anchorCheck")
    public void onCheck(ClickEvent event){
    }


    @Inject
    public HomePageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}