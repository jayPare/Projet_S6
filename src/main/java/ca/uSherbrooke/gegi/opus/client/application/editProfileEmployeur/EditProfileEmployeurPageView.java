/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.ViewImpl;

public class EditProfileEmployeurPageView extends ViewImpl implements EditProfileEmployeurPagePresenter.MyView
{
    //TODO: Ajouter SuggestBox pour les technologies
    //http://gwtbootstrap3.github.io/gwtbootstrap3-demo/#suggestBox
    //TODO: Ajouter SummerNote pour le sommaire
    //http://gwtbootstrap3.github.io/gwtbootstrap3-demo/#summernote
    private final Widget widget;

    @javax.inject.Inject
    DispatchAsync dispatchAsync;

    @Override
    public void setUiHandlers(EditProfileEmployeurPageUiHandlers homePageUiHandlers)
    {

    }

    public interface Binder extends UiBinder<Widget, EditProfileEmployeurPageView>
    {

    }

    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbNom;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbDomaine;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbVille;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea tbTechnologies;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea tbSommaire;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea tbNature;

    EmployerData objEmployerInfos;
    EmployerInfo objEmployerUpdate = new EmployerInfo();

    @UiHandler("btnModifier")
    public void onClick(ClickEvent event)
    {
        updateEmployer();
    }

    public void updateEmployer()
    {
        objEmployerUpdate.m_strName = tbNom.getText();
        objEmployerUpdate.m_strDomain = tbDomaine.getText();
        objEmployerUpdate.m_strLocation = tbVille.getText();
        //objEmployerUpdate.m_strTechnologies =tbTechnologies.getText();
        objEmployerUpdate.m_strSummary = tbSommaire.getText();

        //TODO: Prendre l'ID de l'employeur connecté
        objEmployerUpdate.updateEmployer(1,true);
        dispatchAsync.execute(objEmployerUpdate, employerInfosAsyncCallback);

        //TODO: Verifier pourquoi la modification fail.
    }

    private AsyncCallback<EmployerInfoResult> employerInfosAsyncCallback = new AsyncCallback<EmployerInfoResult>() {
        @Override
        public void onSuccess(EmployerInfoResult result)
        {
            //TODO: Quelque chose à rajouter ici pour dire que la modification est effectué.
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    public void setEmployerInfosObject(EmployerData objEmployerInf)
    {
        this.objEmployerInfos = objEmployerInf;
    }

    public void setEmployerInfos()
    {
        tbNom.setText(objEmployerInfos.getEmployerName());
        tbDomaine.setText(objEmployerInfos.getEmployerDomain());
        tbVille.setText(objEmployerInfos.getEmployerAddress());

        tbSommaire.setText(objEmployerInfos.getEmployerSummary());

        //TODO: Améliorer l'affichage des technologies
        //tbTechnologies.setText(objEmployerInfos.getTechnologies().toString());

        tbNature.setText(objEmployerInfos.getTasks());
    }

    @Inject
    public EditProfileEmployeurPageView(final Binder binder)
    {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget()
    {
        return widget;
    }
}