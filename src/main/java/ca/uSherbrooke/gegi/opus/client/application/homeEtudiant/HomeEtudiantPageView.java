/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEtudiant;

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

public class HomeEtudiantPageView extends ViewImpl implements HomeEtudiantPagePresenter.MyView
{

    private final Widget widget;

    @Override
    public void setUiHandlers(HomeEtudiantPageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, HomeEtudiantPageView> {
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

    public void setUserInfosObject(UserInfosData objUserInfos)
    {
        this.objUserInfos = objUserInfos;
    }

    public void setUserInfos(){
        lblPrenom.setText(objUserInfos.getFirstName());
        lblNom.setText(objUserInfos.getLastName());
        lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
        lblStage.setText(Integer.toString(objUserInfos.getNumeroStage()));
        lblCompetences.setText("changed");
        lblInteretsObjectifs.setText(objUserInfos.getDepartementNom());
    }

    @UiHandler("anchorCheck")
    public void onCheck(ClickEvent event){
    }

    @Inject
    public HomeEtudiantPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}