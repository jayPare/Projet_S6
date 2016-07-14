/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEmployeur;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
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

public class HomeEmployeurPageView extends ViewImpl implements HomeEmployeurPagePresenter.MyView
{

    private final Widget widget;

    @Override
    public void setUiHandlers(HomeEmployeurPageUiHandlers homePageUiHandlers)
    {

    }

    public interface Binder extends UiBinder<Widget, HomeEmployeurPageView>
    {
    }

    public interface checkUiHandlers extends UiHandlers
    {
        void onCheck();
    }

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

    EmployerData objEmployerInfos;

    public void setEmployerInfosObject(EmployerData objEmployerInfos)
    {
        this.objEmployerInfos = objEmployerInfos;
    }

    public void setEmployerInfos()
    {
        lblNomEntreprise.setText(objEmployerInfos.getEmployerName());
        lblDomaine.setText(objEmployerInfos.getEmployerDomain());
        lblAdresse.setText(objEmployerInfos.getEmployerAddress());

        lblSommaire.setText(objEmployerInfos.getEmployerSummary());

        //TODO: Finish this part
        //lblNature.setText(objEmployerInfos.getEmployerNature());
        //lblTechnologies.setText(objEmployerInfos.getEmployerTechs());
    }

    //@UiHandler("anchorCheck")
    //public void onCheck(ClickEvent event){
    //}

    @Inject
    public HomeEmployeurPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}