/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.viewMatches;

import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.ListItem;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.PanelCollapse;
import org.gwtbootstrap3.client.ui.PanelHeader;
import org.gwtbootstrap3.client.ui.gwt.HTMLPanel;
import org.gwtbootstrap3.client.ui.html.Text;

import java.util.List;

public class ViewMatchesPageView extends ViewImpl implements ViewMatchesPagePresenter.MyView {

    private final Widget widget;
    ViewMatchesPageUiHandlers homePageUiHandlers;
    @UiField
    org.gwtbootstrap3.client.ui.PanelGroup panelMatches;

    @Override
    public void setUiHandlers(ViewMatchesPageUiHandlers homePageUiHandlers) {
        this.homePageUiHandlers = homePageUiHandlers;
    }

    public interface Binder extends UiBinder<Widget, ViewMatchesPageView> {
    }

    List<MatchData> objMatchData;

    public void setMatchesObject(List<MatchData> listMatches) {
        this.objMatchData = listMatches;
    }

    public void setMatches(boolean bIsEmployer) {
       /*if (bIsEmployer == false) {
            for (MatchData match : objMatchData) {

                match.getCIPStudent();
                match.getEmailStudent();
                match.getFirstNameStudent();
                match.getLastNameStudent();

                panelMatches.add(panel);
            }
        } else {
            for (MatchData match : objMatchData) {

                match.getPhoneEmployer();
                match.getCIPEmployer();
                match.getEmailEmployer();
                match.getFirstNameEmployer();
                match.getLastNameEmployer();

                panelMatches.add(panel);
            }
        }*/
        //TODO: Trouver un moyen de fetcher les données de objMatchData et de les faire afficher

    }

    public void onRefresh(ClickEvent event) {
        homePageUiHandlers.actionOnRefresh();
    }

    @Inject
    public ViewMatchesPageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}