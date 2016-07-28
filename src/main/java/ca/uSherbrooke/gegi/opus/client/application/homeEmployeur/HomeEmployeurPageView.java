/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
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

public class HomeEmployeurPageView extends ViewImpl implements HomeEmployeurPagePresenter.MyView {
    private final Widget widget;
    EmployerData objEmployerData;


    HomeEmployeurPageUiHandlers homePageUiHandlers;



    @UiField
    org.gwtbootstrap3.client.ui.Heading lblNomEntreprise;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblDomaine;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblAdresse;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblSommaire;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblNature;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblTechnologies;
    @UiField
    org.gwtbootstrap3.client.ui.Panel panelProfile;
    @UiField
    org.gwtbootstrap3.client.ui.Panel panelNoMoreProfile;


    @Override
    public void setUiHandlers(HomeEmployeurPageUiHandlers homePageUiHandlers) {
        this.homePageUiHandlers = homePageUiHandlers;
    }

    public interface Binder extends UiBinder<Widget, HomeEmployeurPageView> {
    }

    public interface checkUiHandlers extends UiHandlers
    {
        void onCheck();
    }

    public void setEmployerInfosObject(EmployerData objEmployerInfos) {
        this.objEmployerData = objEmployerInfos;
    }




    public void setEmployerInfos()
    {

        if (objEmployerData != null) {
            lblNomEntreprise.setText(objEmployerData.getEmployerName());
            lblDomaine.setText(objEmployerData.getEmployerDomain());
            lblAdresse.setText(objEmployerData.getEmployerAddress());
            lblSommaire.setText(objEmployerData.getEmployerSummary());

            lblNature.setText(objEmployerData.getNature());

            //TODO: Modifier l'affichage des technologies
            String technologies = "";
            for (ConceptData tech : objEmployerData.listStrTechnologies) {
                technologies += "- " + tech.getConceptNom() + "<br>";
            }
            lblTechnologies.setHTML(technologies);
        }
        else
        {
            panelProfile.setVisible(false);
            panelNoMoreProfile.setVisible(true);
        }
    }

    @UiHandler("btnRefresh")
    public void onRefreshClick(ClickEvent event)
    {
        this.onRefresh(event);
    }

    public void onRefresh(ClickEvent event)
    {
        homePageUiHandlers.actionOnRefresh();
    }

    @UiHandler("btnLike")
    public void onLikeClick(ClickEvent event) {

        if (objEmployerData != null) {
            homePageUiHandlers.actionOnLike(objEmployerData.getEmployerId());
        }
    }

    @UiHandler("btnDislike")
    public void onDislikeClick(ClickEvent event) {

        if (objEmployerData != null) {
            homePageUiHandlers.actionOnDislike(objEmployerData.getEmployerId());
        }
    }

    @Inject
    public HomeEmployeurPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}