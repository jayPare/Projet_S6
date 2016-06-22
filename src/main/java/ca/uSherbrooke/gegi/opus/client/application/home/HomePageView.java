/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.home;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.FormLabel;

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

    UserInfosData objUserInfos;
    EmployerData objEmployerInfos;

    public void setUserInfosObject(UserInfosData objUserInfos)
    {
        this.objUserInfos = objUserInfos;
    }

    public void setEmployerInfosObject(EmployerData objEmployerInfos)
    {
        this.objEmployerInfos = objEmployerInfos;
    }

    public void setUserInfos(){
        lblPrenom.setText(objUserInfos.getFirstName());
        lblNom.setText(objUserInfos.getLastName());
        lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
        lblStage.setText(Integer.toString(objUserInfos.getNumeroStage()));
        lblCompetences.setText("changed");
        lblInteretsObjectifs.setText(objUserInfos.getDepartementNom());
    }

    public void setEmployerInfos(){
        lblPrenom.setHTML("employer sommaire = " +objEmployerInfos.getEmployerName());
        lblNom.setText("employer nature = " +objEmployerInfos.getEmployerDomain());
        lblProgrammeEtude.setText("employer fonction = " +objEmployerInfos.getEmployerSummary());
        lblStage.setText("employer technologies = " +objEmployerInfos.getEmployerAddress());
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