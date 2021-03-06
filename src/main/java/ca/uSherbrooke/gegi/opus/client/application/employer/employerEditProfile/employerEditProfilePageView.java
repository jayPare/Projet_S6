/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.employer.employerEditProfile;

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
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.gwtbootstrap3.extras.notify.client.ui.NotifySettings;

import java.util.List;


public class employerEditProfilePageView extends ViewImpl implements employerEditProfilePagePresenter.MyView
{

    //TODO: Ajouter SuggestBox pour les technologies
    //http://gwtbootstrap3.github.io/gwtbootstrap3-demo/#suggestBox
    //TODO: Ajouter SummerNote pour le sommaire
    //http://gwtbootstrap3.github.io/gwtbootstrap3-demo/#summernote
    private final Widget widget;

    @javax.inject.Inject
    DispatchAsync dispatchAsync;

    employerEditProfilePageUiHandlers homePageUiHandlers;

    @Override
    public void setUiHandlers(employerEditProfilePageUiHandlers homePageUiHandlers)
    {
        this.homePageUiHandlers = homePageUiHandlers;
    }


    public interface Binder extends UiBinder<Widget, employerEditProfilePageView>
    {

    }

    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbNom;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbDomaine;
    @UiField
    org.gwtbootstrap3.client.ui.TextBox tbVille;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea tbSommaire;
    @UiField
    org.gwtbootstrap3.client.ui.TextArea tbNature;
    @UiField
    org.gwtbootstrap3.client.ui.Panel panelTechnologies;
    @UiField
    org.gwtbootstrap3.client.ui.Column panelSelectEmployeur;
    @UiField
    org.gwtbootstrap3.client.ui.Button btnAjouter;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddlSelectEmployeur;

    EmployerData objEmployerInfos;
    EmployerInfo objEmployerUpdate = new EmployerInfo();
    int idEmployer;
    List<EmployerData> objEmployerListInfos;


    @UiHandler("btnModifier")
    public void onClick(ClickEvent event)
    {
        updateEmployer();
    }

    @UiHandler("btnAjouter")
    public void onClickAjouter(ClickEvent event)
    {
        btnAjouter.setVisible(false);

        org.gwtbootstrap3.extras.select.client.ui.Select sbTechs = new org.gwtbootstrap3.extras.select.client.ui.Select();

        org.gwtbootstrap3.extras.select.client.ui.Option option1 = new org.gwtbootstrap3.extras.select.client.ui.Option();
        org.gwtbootstrap3.extras.select.client.ui.Option option2 = new org.gwtbootstrap3.extras.select.client.ui.Option();
        org.gwtbootstrap3.extras.select.client.ui.Option option3 = new org.gwtbootstrap3.extras.select.client.ui.Option();

        option1.setText("Test1");
        option2.setText("Test2");
        option3.setText("Test3");

        sbTechs.add(option1);
        sbTechs.add(option2);
        sbTechs.add(option3);

        panelTechnologies.add(sbTechs);
    }

    @UiHandler("btnSelectEmployeur")
    public void onClickBtnSelectEmployeur(ClickEvent event)
    {
        String selected  = ddlSelectEmployeur.getSelectedItem().getValue();

        int i = 0;

        for (EmployerData emp : this.objEmployerListInfos)
        {
            i++;

            if (emp.getEmployerName() == selected)
            {
                updateEmployerInfosObject(this.objEmployerInfos = emp);
                break;
            }
        }

        setEmployerInfos();
    }

    public void setEmployerInfoListObject(List<EmployerData> objEmployerListInfos)
    {
        this.objEmployerListInfos = objEmployerListInfos;

    }

    public void updateEmployer()
    {
        objEmployerUpdate.m_strName = tbNom.getText();
        objEmployerUpdate.m_strDomain = tbDomaine.getText();
        objEmployerUpdate.m_strLocation = tbVille.getText();
        //objEmployerUpdate.m_listStrTechnologies = tbTechnologies.getText();
        //TODO : the user only can choose between a list of technologies
        objEmployerUpdate.m_strSummary = tbSommaire.getText();
        objEmployerUpdate.updateEmployer(objEmployerInfos.getEmployerId(),true);

        dispatchAsync.execute(objEmployerUpdate, updateEmployerAsyncCallback);

        //TODO: Verifier pourquoi la modification fail.
    }

    private AsyncCallback<EmployerInfoResult> updateEmployerAsyncCallback = new AsyncCallback<EmployerInfoResult>() {
        @Override
        public void onSuccess(EmployerInfoResult result)
        {
            Notify.notify("Modification effectué avec succès.");
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

    public void updateEmployerInfosObject(EmployerData objEmployerInf)
    {
        this.objEmployerInfos = objEmployerInf;
    }


    public void setEmployerInfos()
    {

        tbNom.setText(objEmployerInfos.getEmployerName());
        tbDomaine.setText(objEmployerInfos.getEmployerDomain());
        tbVille.setText(objEmployerInfos.getEmployerAddress());

        tbSommaire.setText(objEmployerInfos.getEmployerSummary());
        tbNature.setText(objEmployerInfos.getNature());

        panelTechnologies.remove(btnAjouter);

        for (ConceptData tech : objEmployerInfos.listStrTechnologies)
        {
            org.gwtbootstrap3.client.ui.Row rowTechnologies = new org.gwtbootstrap3.client.ui.Row();
            org.gwtbootstrap3.client.ui.Column columnTechnologieNom = new org.gwtbootstrap3.client.ui.Column(ColumnSize.LG_2);
            org.gwtbootstrap3.client.ui.Column columnTechnologieButton = new org.gwtbootstrap3.client.ui.Column(ColumnSize.LG_2);

            org.gwtbootstrap3.client.ui.html.Paragraph lblTechnologie = new org.gwtbootstrap3.client.ui.html.Paragraph();
            lblTechnologie.setText(tech.getConceptNom());
            columnTechnologieNom.add(lblTechnologie);
            org.gwtbootstrap3.client.ui.Button btnDelete = new org.gwtbootstrap3.client.ui.Button();
            btnDelete.setText("Supprimer");
            btnDelete.setType(ButtonType.DANGER);

            columnTechnologieButton.add(btnDelete);

            rowTechnologies.add(columnTechnologieNom);

            columnTechnologieNom.setPaddingTop(8);
            rowTechnologies.add(columnTechnologieButton);

            rowTechnologies.setMarginBottom(8);

            panelTechnologies.add(rowTechnologies);

        }

        panelTechnologies.add(btnAjouter);
    }

    public void populateDropdownEmployer()
    {

        int index = 0;

        ddlSelectEmployeur.clear();

        for (EmployerData emp : objEmployerListInfos)
        {
            org.gwtbootstrap3.extras.select.client.ui.Option employeur1 = new org.gwtbootstrap3.extras.select.client.ui.Option();

            employeur1.setText(emp.getEmployerName());

            ddlSelectEmployeur.add(employeur1);
            ddlSelectEmployeur.refresh();
            index++;
        }
    }

    @Inject
    public employerEditProfilePageView(final Binder binder)
    {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget()
    {
        return widget;
    }
}