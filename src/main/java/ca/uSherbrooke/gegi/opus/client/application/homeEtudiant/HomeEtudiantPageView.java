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
import com.gwtplatform.mvp.client.ViewImpl;

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
    org.gwtbootstrap3.client.ui.ProgressBar pbCompetence1;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbCompetence2;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbCompetence3;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbInteret1;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbInteret2;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbInteret3;

    @Override
    public void setUiHandlers(HomeEtudiantPageUiHandlers homePageUiHandlers)
    {
        this.homePageUiHandlers = homePageUiHandlers;
    }

    public interface Binder extends UiBinder<Widget, HomeEtudiantPageView>
    {

    }

    public void setUserInfosObject(UserInfoData objUserInfos)
    {
        this.objUserInfos = objUserInfos;
    }

    public void setUserInfos()
    {
        if (objUserInfos != null)
        {
            lblNom.setText(objUserInfos.getFirstName() + " " + objUserInfos.getLastName());
            lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
            lblStage.setText("Stage: " + Integer.toString(objUserInfos.getNumeroStage()));

            List<ConceptData> listeCompetences = objUserInfos.getCompetence();
            List<ConceptData> listeInterets = objUserInfos.getInteret();

            for (int i = 0; i < listeCompetences.size(); i++) {
                if(i == 1)
                {
                    pbCompetence1.setPercent(listeCompetences.get(i).getNiveauSur5() * 20);
                    pbCompetence1.setText(Integer.toString(listeCompetences.get(i).getNiveauSur5()));

                    pbInteret1.setPercent(listeInterets.get(i).getNiveauSur5() * 20);
                    pbInteret1.setText(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                }
                else if (i == 2)
                {
                    pbCompetence2.setPercent(listeCompetences.get(i).getNiveauSur5() * 20);
                    pbCompetence2.setText(Integer.toString(listeCompetences.get(i).getNiveauSur5()));

                    pbInteret2.setPercent(listeInterets.get(i).getNiveauSur5() * 20);
                    pbInteret2.setText(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                }
                else if (i == 3)
                {
                    pbCompetence3.setPercent(listeCompetences.get(i).getNiveauSur5() * 20);
                    pbCompetence3.setText(Integer.toString(listeCompetences.get(i).getNiveauSur5()));

                    pbInteret3.setPercent(listeInterets.get(i).getNiveauSur5() * 20);
                    pbInteret3.setText(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                }

            }
        }
        else
        {
            //TODO : find a way to hide everything and display only a message to say there arent any more stagiaire + a refresh button -> use fonction onRefresh
            lblNom.setText("Il n'y a plus de stagiaires ...");
        }
    }
    
    public void onRefresh(ClickEvent event)
    {
        homePageUiHandlers.actionOnRefresh();
    }

    @UiHandler("btnLike")
    public void onLikeClick(ClickEvent event)
    {
        if (objUserInfos != null)
        {
            homePageUiHandlers.actionOnLike(objUserInfos.getStagiaireID());
        }
    }

    @UiHandler("btnDislike")
    public void onDislikeClick(ClickEvent event)
    {
        if (objUserInfos != null)
        {
            homePageUiHandlers.actionOnDislike(objUserInfos.getStagiaireID());
        }
    }

    @Inject
    public HomeEtudiantPageView(final Binder binder)
    {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget()
    {
        return widget;
    }
}