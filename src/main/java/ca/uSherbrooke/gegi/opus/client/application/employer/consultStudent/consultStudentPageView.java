/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.employer.consultStudent;

import ca.uSherbrooke.gegi.opus.shared.entity.ConceptData;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import java.util.List;

public class consultStudentPageView extends ViewImpl implements consultStudentPagePresenter.MyView {

    private final Widget widget;
    UserInfoData objUserInfos;
    consultStudentPageUiHandlers homePageUiHandlers;
    List<EmployerData> objEmployerListInfos;
    int idEmployer;
    @UiField
    org.gwtbootstrap3.client.ui.Panel panelProfil;
    @UiField
    org.gwtbootstrap3.client.ui.Panel panelNoMoreProfile;
    @UiField
    org.gwtbootstrap3.client.ui.Heading lblNom;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblProgrammeEtude;
    @UiField
    org.gwtbootstrap3.client.ui.html.Paragraph lblStage;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbCompetence1;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbCompetence2;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbCompetence3;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbInteret1;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbInteret2;
    @UiField
    org.gwtbootstrap3.client.ui.ProgressBar pbInteret3;
    @UiField
    org.gwtbootstrap3.extras.select.client.ui.Select ddSelectEmployeur;

    @Override
    public void setUiHandlers(consultStudentPageUiHandlers homePageUiHandlers) {
        this.homePageUiHandlers = homePageUiHandlers;
    }

    public interface Binder extends UiBinder<Widget, consultStudentPageView> {

    }

    public void setEmployerID() {
        String selectedEmployerName = ddSelectEmployeur.getSelectedItem().getValue();

        for (EmployerData emp : objEmployerListInfos) {
            if (emp.getEmployerName() == selectedEmployerName) {
                idEmployer = emp.getEmployerId();
                setPresenterEmployerID(idEmployer);
            }
        }
    }

    @UiHandler("btnSelectEmployeur")
    public void onClickBtnSelectEmployeur(ClickEvent event) {
        setEmployerID();
    }

    public void setUserInfosObject(UserInfoData objUserInfos) {
        this.objUserInfos = objUserInfos;
    }

    public void setEmployerInfoListObject(List<EmployerData> objEmployerListInfos) {
        this.objEmployerListInfos = objEmployerListInfos;
    }

    public void setEmployerInfos()
    {
        int index = 0;

        ddSelectEmployeur.clear();

        for (EmployerData empl : objEmployerListInfos)
        {
            org.gwtbootstrap3.extras.select.client.ui.Option employeur1 = new org.gwtbootstrap3.extras.select.client.ui.Option();

            if (index == 0)
            {
                idEmployer = empl.getEmployerId();
                setPresenterEmployerID(idEmployer);
            }

            employeur1.setText(empl.getEmployerName());

            ddSelectEmployeur.add(employeur1);
            ddSelectEmployeur.refresh();
            index++;
        }
    }

    public void setUserInfos() {
        if (objUserInfos != null) {

            panelProfil.setVisible(true);
            panelNoMoreProfile.setVisible(false);

            lblNom.setText(objUserInfos.getFirstName() + " " + objUserInfos.getLastName());
            lblProgrammeEtude.setText(objUserInfos.getDepartementNom());
            lblStage.setText("Stage: " + Integer.toString(objUserInfos.getNumeroStage()));

            List<ConceptData> listeCompetences = objUserInfos.getCompetence();
            List<ConceptData> listeInterets = objUserInfos.getInteret();

            for (int i = 0; i < listeCompetences.size(); i++) {
                if (i == 1) {
                    pbCompetence1.setPercent(listeCompetences.get(i).getNiveauSur5() * 20);
                    pbCompetence1.setText(Integer.toString(listeCompetences.get(i).getNiveauSur5()));

                    pbInteret1.setPercent(listeInterets.get(i).getNiveauSur5() * 20);
                    pbInteret1.setText(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                } else if (i == 2) {
                    pbCompetence2.setPercent(listeCompetences.get(i).getNiveauSur5() * 20);
                    pbCompetence2.setText(Integer.toString(listeCompetences.get(i).getNiveauSur5()));

                    pbInteret2.setPercent(listeInterets.get(i).getNiveauSur5() * 20);
                    pbInteret2.setText(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                } else if (i == 3) {
                    pbCompetence3.setPercent(listeCompetences.get(i).getNiveauSur5() * 20);
                    pbCompetence3.setText(Integer.toString(listeCompetences.get(i).getNiveauSur5()));

                    pbInteret3.setPercent(listeInterets.get(i).getNiveauSur5() * 20);
                    pbInteret3.setText(Integer.toString(listeInterets.get(i).getNiveauSur5()));
                }

            }
        } else {
            panelProfil.setVisible(false);
            panelNoMoreProfile.setVisible(true);
        }
    }

    public void onRefresh(ClickEvent event) {
        homePageUiHandlers.actionOnRefresh();
    }

    @UiHandler("btnLike")
    public void onLikeClick(ClickEvent event) {
        if (objUserInfos != null) {
            homePageUiHandlers.actionOnLike(objUserInfos.getStagiaireID(), idEmployer);
        }
    }

    @UiHandler("btnRefresh")
    public void onRefreshClick(ClickEvent event) {
        this.onRefresh(event);
    }

    @UiHandler("btnDislike")
    public void onDislikeClick(ClickEvent event) {
        if (objUserInfos != null) {
            homePageUiHandlers.actionOnDislike(objUserInfos.getStagiaireID(), idEmployer);
        }
    }

    public void setPresenterEmployerID(int employerID) {
        homePageUiHandlers.setPresenterEmployerID(idEmployer);
    }

    @Inject
    public consultStudentPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}