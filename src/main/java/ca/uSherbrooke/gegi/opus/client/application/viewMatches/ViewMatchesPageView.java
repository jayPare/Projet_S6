/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.viewMatches;

import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import java.util.List;

public class ViewMatchesPageView extends ViewImpl implements ViewMatchesPagePresenter.MyView {

    private final Widget widget;
    ViewMatchesPageUiHandlers homePageUiHandlers;

    @UiField
    org.gwtbootstrap3.client.ui.PanelGroup panelMatches;

    @Override
    public void setUiHandlers(ViewMatchesPageUiHandlers homePageUiHandlers)
    {
        this.homePageUiHandlers = homePageUiHandlers;
    }

    public interface Binder extends UiBinder<Widget, ViewMatchesPageView>
    {
    }

    List<MatchData> objMatchData;

    public void setMatchesObject(List<MatchData> listMatches)
    {
        this.objMatchData = listMatches;
    }

    public void setMatches(boolean bIsEmployer)
    {
        //TODO: Verifier que tout fonctionne en ajoutant des matches dans la BD et enlever les match hardcoder dans le ui.

        if (bIsEmployer == false)
        {
            for (MatchData match : objMatchData)
            {
                org.gwtbootstrap3.client.ui.Panel panel = new org.gwtbootstrap3.client.ui.Panel();
                org.gwtbootstrap3.client.ui.Heading header = new org.gwtbootstrap3.client.ui.Heading(HeadingSize.H4);
                header.setText(match.getFirstNameStudent() + " " + match.getLastNameStudent());

                org.gwtbootstrap3.client.ui.PanelHeader panelHeader = new org.gwtbootstrap3.client.ui.PanelHeader();
                panelHeader.setDataToggle(Toggle.COLLAPSE);
                panelHeader.setDataTarget(match.getId().toString());
                panelHeader.add(header);

                org.gwtbootstrap3.client.ui.PanelCollapse panelCollapse = new org.gwtbootstrap3.client.ui.PanelCollapse();
                org.gwtbootstrap3.client.ui.PanelBody panelBody = new org.gwtbootstrap3.client.ui.PanelBody();

                org.gwtbootstrap3.client.ui.html.Paragraph courriel = new org.gwtbootstrap3.client.ui.html.Paragraph();
                courriel.setText("Courriel: " + match.getEmailStudent());

                org.gwtbootstrap3.client.ui.html.Paragraph telephone = new org.gwtbootstrap3.client.ui.html.Paragraph();
                telephone.setText("Telephone: " + match.getPhoneStudent());

                panelCollapse.setId(match.getId().toString());

                panelBody.add(courriel);
                panelBody.add(telephone);
                panelCollapse.add(panelBody);

                panel.add(panelHeader);
                panel.add(panelCollapse);
            }
        }
        else
        {
            for (MatchData match : objMatchData)
            {
                org.gwtbootstrap3.client.ui.Panel panel = new org.gwtbootstrap3.client.ui.Panel();
                org.gwtbootstrap3.client.ui.Heading header = new org.gwtbootstrap3.client.ui.Heading(HeadingSize.H4);
                header.setText(match.getCompanyName());

                org.gwtbootstrap3.client.ui.PanelHeader panelHeader = new org.gwtbootstrap3.client.ui.PanelHeader();
                panelHeader.setDataToggle(Toggle.COLLAPSE);
                panelHeader.setDataTarget(match.getId().toString());
                panelHeader.add(header);

                org.gwtbootstrap3.client.ui.PanelCollapse panelCollapse = new org.gwtbootstrap3.client.ui.PanelCollapse();
                org.gwtbootstrap3.client.ui.PanelBody panelBody = new org.gwtbootstrap3.client.ui.PanelBody();

                org.gwtbootstrap3.client.ui.html.Paragraph courriel = new org.gwtbootstrap3.client.ui.html.Paragraph();
                courriel.setText("Courriel: " + match.getEmailEmployer());

                org.gwtbootstrap3.client.ui.html.Paragraph telephone = new org.gwtbootstrap3.client.ui.html.Paragraph();
                telephone.setText("Telephone: " + match.getPhoneEmployer());

                panelCollapse.setId(match.getId().toString());

                panelBody.add(courriel);
                panelBody.add(telephone);
                panelCollapse.add(panelBody);

                panel.add(panelHeader);
                panel.add(panelCollapse);
            }
        }
    }


    public void onRefresh(ClickEvent event)
    {
        homePageUiHandlers.actionOnRefresh();
    }

    @Inject
    public ViewMatchesPageView(final Binder binder)
    {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget()
    {
        return widget;
    }
}