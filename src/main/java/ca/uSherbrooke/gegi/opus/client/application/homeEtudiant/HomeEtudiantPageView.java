/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEtudiant;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
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

import java.util.List;

public class HomeEtudiantPageView extends ViewImpl implements HomeEtudiantPagePresenter.MyView {

    private final Widget widget;
    UserInfoData objUserInfos;
    HomeEtudiantPageUiHandlers homePageUiHandlers;

    @UiField
    org.gwtbootstrap3.client.ui.Heading lblNom;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblProgrammeEtude;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblStage;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph taCompetences;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph taInteretsObjectifs;

    @Override
    public void setUiHandlers(HomeEtudiantPageUiHandlers homePageUiHandlers) {
        this.homePageUiHandlers = homePageUiHandlers;
    }

    public interface Binder extends UiBinder<Widget, HomeEtudiantPageView> {

    }

    public void setUserInfosObject(UserInfoData objUserInfos) {
        this.objUserInfos = objUserInfos;
    }

    public void setUserInfos() {
        if (objUserInfos != null) {
            lblNom.setText(objUserInfos.getFirstName() + " " + objUserInfos.getLastName());
            lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
            lblStage.setText("Stage: " + Integer.toString(objUserInfos.getNumeroStage()));

            List<ConceptData> listeCompetences = objUserInfos.getCompetence();
            List<ConceptData> listeInterets = objUserInfos.getInteret();

            taCompetences.setText("");
            taInteretsObjectifs.setText("");

            for (int i = 0; i < listeCompetences.size(); i++) {
                taCompetences.setText(taCompetences.getText() + listeCompetences.get(i).getConceptNom() + ": " + listeCompetences.get(i).getNiveauSur5() + "\n");
            }

            for (int i = 0; i < listeInterets.size(); i++) {
                taInteretsObjectifs.setText(taInteretsObjectifs.getText() + listeInterets.get(i).getConceptNom() + ": " + listeInterets.get(i).getNiveauSur5() + "\n");
            }
        } else {
            //Todo : find a way to hide everything and display only a message to say there arent any more stagiaire + a refresh button -> use fonction onRefresh
            lblNom.setText("Il n'y a plus de stagiaires ...");
        }
    }
    
    public void onRefresh(ClickEvent event) {
        homePageUiHandlers.actionOnRefresh();
    }

    @UiHandler("btnLike")
    public void onLikeClick(ClickEvent event) {
        if (objUserInfos != null) {
            homePageUiHandlers.actionOnLike(objUserInfos.getStagiaireID());
        }
    }

    @UiHandler("btnDislike")
    public void onDislikeClick(ClickEvent event) {

        if (objUserInfos != null) {
            homePageUiHandlers.actionOnDislike(objUserInfos.getStagiaireID());
        }
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