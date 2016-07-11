/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.inscriptionEmployeur;

import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class InscriptionEmployeurPageView extends ViewImpl implements InscriptionEmployeurPagePresenter.MyView
{

    private final Widget widget;

    @Override
    public void setUiHandlers(InscriptionEmployeurPageUiHandlers homePageUiHandlers) {

    }

    public interface Binder extends UiBinder<Widget, InscriptionEmployeurPageView> {
    }

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

    GetEmployerInfos objEmployerInfo = new GetEmployerInfos();

    public void insertNewEmployer()
    {
        objEmployerInfo.m_strName = tbNomEntreprise.getText();
        objEmployerInfo.m_strDomain =tbDomaine.getText();
        objEmployerInfo.m_strLocation =tbLieu.getText();
        //TODO: ajouter ces champ là à l'objet GetEmployerInfos
        //objEmployerInfo.m_strTechnologies =tbTechnologies.getText();
        //objEmployerInfo.m_strSommaire =tbSommaire.getText();

        objEmployerInfo.insertNewEmployer(true);
    }

    @Inject
    public InscriptionEmployeurPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}