/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.ViewImpl;

import java.util.List;

public class EditProfileEtudiantPageView extends ViewImpl implements EditProfileEtudiantPagePresenter.MyView
{
    //TODO: Ajouterr SuggestBox pour les competences et les interets
    private final Widget widget;

    @javax.inject.Inject
    DispatchAsync dispatchAsync;

    @Override
    public void setUiHandlers(EditProfileEtudiantPageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, EditProfileEtudiantPageView>
    {
        
    }

    UserInfoData objUserInfos;
    UserInfo objStudentUpdate = new UserInfo();

    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblPrenom;
    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblNom;
    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblProgrammeEtude;
    @UiField
    org.gwtbootstrap3.client.ui.FormControlStatic lblStage;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddCompetence1;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddCompetence2;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddCompetence3;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddInteret1;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddInteret2;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddInteret3;


    public void setUserInfosObject(UserInfoData objUserInfos)
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

        List<ConceptData> listeInterets = objUserInfos.getInteret();

        //TODO: Améliorer la modification des compétences et intérêts pour pouvoir rajouter des competences et des interets.
        for (int i=0;i <  listeInterets.size();i++)
        {
            if(i == 1)
            {
                ddInteret1.setValue(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                ddCompetence1.setValue(Integer.toString(listeCompetences.get(i).getNiveauSur5()));
            }
            else if (i == 2)
            {
                ddInteret2.setValue(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                ddCompetence2.setValue(Integer.toString(listeCompetences.get(i).getNiveauSur5()));
            }
            else if (i == 3)
            {
                ddInteret3.setValue(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                ddCompetence3.setValue(Integer.toString(listeCompetences.get(i).getNiveauSur5()));
            }
        }
    }

    @UiHandler("btnUpdate")
    public void onClick(ClickEvent event)
    {
        updateStudent();
    }

    public void updateStudent()
    {
        List<ConceptData> listeCompetencesUpdate = objUserInfos.getCompetence();
        List<ConceptData> listeInteretsUpdate = objUserInfos.getInteret();

        listeCompetencesUpdate.get(0).setNiveauSur5(Integer.parseInt(ddCompetence1.getValue()));
        listeCompetencesUpdate.get(1).setNiveauSur5(Integer.parseInt(ddCompetence2.getValue()));
        listeCompetencesUpdate.get(2).setNiveauSur5(Integer.parseInt(ddCompetence3.getValue()));

        listeInteretsUpdate.get(0).setNiveauSur5(Integer.parseInt(ddInteret1.getValue()));
        listeInteretsUpdate.get(1).setNiveauSur5(Integer.parseInt(ddInteret2.getValue()));
        listeInteretsUpdate.get(2).setNiveauSur5(Integer.parseInt(ddInteret3.getValue()));

        objStudentUpdate.m_objListCompetence = listeCompetencesUpdate;
        objStudentUpdate.m_objListInteret = listeInteretsUpdate;

        //TODO: Prendre l'ID de l'employeur connecté
        objStudentUpdate.updateStudent(1,true);
        dispatchAsync.execute(objStudentUpdate, studentInfosAsyncCallback);
    }

    private AsyncCallback<UserInfoResult> studentInfosAsyncCallback = new AsyncCallback<UserInfoResult>() {
        @Override
        public void onSuccess(UserInfoResult result)
        {
            //TODO: Quelque chose à rajouter ici pour dire que la modification est effectué.
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    @Inject
    public EditProfileEtudiantPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}