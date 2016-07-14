/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfosResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.FormLabel;

import java.util.List;

public class EditProfileEtudiantPageView extends ViewImpl implements EditProfileEtudiantPagePresenter.MyView
{

    private final Widget widget;

    @javax.inject.Inject
    DispatchAsync dispatchAsync;

    @Override
    public void setUiHandlers(EditProfileEtudiantPageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, EditProfileEtudiantPageView>
    {
        
    }

    UserInfosData objUserInfos;
    GetUserInfos objStudentUpdate = new GetUserInfos();

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

        //TODO: Améliorer la modif des cométences et intérêts.
        for (int i=0;i < listeCompetences.size();i++)
        {
            taCompetences.setText(taCompetences.getText() + listeCompetences.get(i).getConceptNom() + ": " + listeCompetences.get(i).getNiveauSur5() + " ");
        }

        for (int i=0; i < listeInterets.size(); i++)
        {
            taInteretsObjectifs.setText(taInteretsObjectifs.getText() + listeInterets.get(i).getConceptNom() + ": " + listeInterets.get(i).getNiveauSur5() + " ");
        }
    }

    @UiHandler("btnUpdate")
    public void onClick(ClickEvent event)
    {
        updateStudent();
    }

    public void updateStudent()
    {
        //TODO: Faire la modification des champ de objStudentUpdate avec ce qu'on retrouve dans la page.


        //TODO: Prendre l'ID de l'employeur connecté
        objStudentUpdate.updateStudent(1,true);
        dispatchAsync.execute(objStudentUpdate, studentInfosAsyncCallback);
    }

    private AsyncCallback<GetUserInfosResult> studentInfosAsyncCallback = new AsyncCallback<GetUserInfosResult>() {
        @Override
        public void onSuccess(GetUserInfosResult result)
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