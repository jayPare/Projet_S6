/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEmployeur;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
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

public class HomeEmployeurPageView extends ViewImpl implements HomeEmployeurPagePresenter.MyView {
    private final Widget widget;
    EmployerData objEmployerInfos;
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

    public interface checkUiHandlers extends UiHandlers {
        void onCheck();
    }

    public void setEmployerInfosObject(EmployerData objEmployerInfos) {
        this.objEmployerInfos = objEmployerInfos;
    }

    public void setEmployerInfos() {
        if (objEmployerInfos != null) {
            lblNomEntreprise.setText(objEmployerInfos.getEmployerName());
            lblDomaine.setText(objEmployerInfos.getEmployerDomain());
            lblAdresse.setText(objEmployerInfos.getEmployerAddress());
            lblSommaire.setText(objEmployerInfos.getEmployerSummary());
            lblNature.setText(objEmployerInfos.getTasks());
            String technologies = "";
            for (String tech : objEmployerInfos.getTechnologies()) {
                technologies += tech + ",";
            }
            lblTechnologies.setText(technologies);
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

        if (objEmployerInfos != null) {
            homePageUiHandlers.actionOnLike(objEmployerInfos.getEmployerId());
        }
    }

    @UiHandler("btnDislike")
    public void onDislikeClick(ClickEvent event) {

        if (objEmployerInfos != null) {
            homePageUiHandlers.actionOnDislike(objEmployerInfos.getEmployerId());
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