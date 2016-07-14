/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant;

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

public class EditProfileEtudiantPageView extends ViewImpl implements EditProfileEtudiantPagePresenter.MyView
{

    private final Widget widget;

    @Override
    public void setUiHandlers(EditProfileEtudiantPageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, EditProfileEtudiantPageView>
    {
        
    }

    public interface checkUiHandlers extends UiHandlers
    {
        void onCheck();
    }

    UserInfosData objUserInfos;

    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblPrenom;
    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblNom;
    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblProgrammeEtude;
    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblStage;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea taCompetences;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea taInteretsObjectifs;

    public void setUserInfosObject(UserInfosData objUserInfos)
    {
        this.objUserInfos = objUserInfos;
    }

    public void setUserInfos()
    {
        lblPrenom.setText(objUserInfos.getFirstName());
        lblNom.setText(objUserInfos.getLastName());
        lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
        lblStage.setText(Integer.toString(objUserInfos.getNumeroStage()));

        List<ConceptData> listeCompetences = objUserInfos.getCompetence();
        taCompetences.setText("");

        List<ConceptData> listeInterets = objUserInfos.getInteret();
        taInteretsObjectifs.setText("");

        for (int i=0;i < listeCompetences.size();i++)
        {
            taCompetences.setText(taCompetences.getText() + listeCompetences.get(i).getConceptNom() + ": " + listeCompetences.get(i).getNiveauSur5() + " ");
        }

        for (int i=0; i < listeInterets.size(); i++)
        {
            taInteretsObjectifs.setText(taInteretsObjectifs.getText() + listeInterets.get(i).getConceptNom() + ": " + listeInterets.get(i).getNiveauSur5() + " ");
        }
    }

    //@UiHandler("anchorCheck")
    public void onCheck(ClickEvent event){
    }

    @Inject
    public EditProfileEtudiantPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}