/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur;

import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
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

public class EditProfileEmployeurPageView extends ViewImpl implements EditProfileEmployeurPagePresenter.MyView
{

    private final Widget widget;

    @Override
    public void setUiHandlers(EditProfileEmployeurPageUiHandlers homePageUiHandlers)
    {

    }

    public interface Binder extends UiBinder<Widget, EditProfileEmployeurPageView>
    {
    }

    public interface checkUiHandlers extends UiHandlers
    {
        void onCheck();
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


    public void setEmployerInfosObject(EmployerData objEmployerInfos)
    {
        this.objEmployerInfos = objEmployerInfos;
    }

    public void setEmployerInfos()
    {

    }

    public void getEmployerInfosObject(EmployerData objEmployerInfos)
    {

    }

    public void getEmployerInfos()
    {

    }

    //@UiHandler("anchorCheck")
    public void onCheck(ClickEvent event)
    {
    }

    @Inject
    public EditProfileEmployeurPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}