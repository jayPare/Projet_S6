/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.inscriptionEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfoResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfoResult;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.ViewImpl;

public class InscriptionEmployeurPageView extends ViewImpl implements InscriptionEmployeurPagePresenter.MyView
{

    //TODO: Refaire le style pour la page d'inscription des employeurs

    private final Widget widget;

    @javax.inject.Inject
    DispatchAsync dispatchAsync;

    @Override
    public void setUiHandlers(InscriptionEmployeurPageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, InscriptionEmployeurPageView> {
    }

    EmployerInfo objEmployerInfo = new EmployerInfo();

    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbNomEntreprise;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbDomaine;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbLieu;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbTechnologies;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbSommaire;

    @UiHandler("btnSubscribe")
    public void onClick(ClickEvent event)
    {
        insertNewEmployer();
    }

    public void insertNewEmployer()
    {
        objEmployerInfo.m_strName = tbNomEntreprise.getText();
        objEmployerInfo.m_strDomain = tbDomaine.getText();
        objEmployerInfo.m_strLocation = tbLieu.getText();
        //objEmployerInfo.m_strTechnologies =tbTechnologies.getText();
        //TODO : technologies = list de string
        objEmployerInfo.m_strSummary = tbSommaire.getText();
        //TODO: Ajouter le CIP de l'employeur déja connecté.
        objEmployerInfo.insertNewEmployer("degs2601",true);
        dispatchAsync.execute(objEmployerInfo, employerInfosAsyncCallback);

        MatchInfo MatchInfo = new MatchInfo();
        MatchInfo.getMatchEmployer(1,true);
        dispatchAsync.execute(MatchInfo, matchInfosAsyncCallback);
    }


    private AsyncCallback<EmployerInfoResult> employerInfosAsyncCallback = new AsyncCallback<EmployerInfoResult>() {
        @Override
        public void onSuccess(EmployerInfoResult result) {
            //?
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    private AsyncCallback<MatchInfoResult> matchInfosAsyncCallback = new AsyncCallback<MatchInfoResult>() {
        @Override
        public void onSuccess(MatchInfoResult result) {
            //?
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    @Inject
    public InscriptionEmployeurPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}