/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEtudiant;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
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

import java.util.List;

public class HomeEtudiantPageView extends ViewImpl implements HomeEtudiantPagePresenter.MyView
{

    private final Widget widget;

    @Override
    public void setUiHandlers(HomeEtudiantPageUiHandlers homePageUiHandlers)
    {

    }

    public interface Binder extends UiBinder<Widget, HomeEtudiantPageView>
    {

    }

    //public interface checkUiHandlers extends UiHandlers {
    //    void onCheck();
    //}

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

    UserInfosData objUserInfos;

    public void setUserInfosObject(UserInfosData objUserInfos)
    {
        this.objUserInfos = objUserInfos;
    }

    public void setUserInfos(){
        lblNom.setText(objUserInfos.getFirstName() + " " +  objUserInfos.getLastName());
        lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
        lblStage.setText("Stage: " + Integer.toString(objUserInfos.getNumeroStage()));

        List<ConceptData> listeCompetences = objUserInfos.getCompetence();
        List<ConceptData> listeInterets = objUserInfos.getInteret();

        taCompetences.setText("");
        taInteretsObjectifs.setText("");

        for (int i=0;i < listeCompetences.size();i++)
        {
            taCompetences.setText(taCompetences.getText() + listeCompetences.get(i).getConceptNom() + ": " + listeCompetences.get(i).getNiveauSur5() + " ");
            //taCompetences.setHTML(taCompetences.getHTML() + "<br />");
        }

        for (int i=0; i < listeInterets.size(); i++)
        {
            taInteretsObjectifs.setText(taInteretsObjectifs.getText() + listeInterets.get(i).getConceptNom() + ": " + listeInterets.get(i).getNiveauSur5() + " ");
        }
    }

    @UiHandler("btnLike")
    public void onLikeClick(ClickEvent event)
    {

    }

    @UiHandler("btnDislike")
    public void onDislikeClick(ClickEvent event)
    {

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