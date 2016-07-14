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

import java.util.List;

public class ViewMatchesPageView extends ViewImpl implements ViewMatchesPagePresenter.MyView
{

    private final Widget widget;
    
    @UiField
    org.gwtbootstrap3.client.ui.PanelGroup panelMatches;

    @Override
    public void setUiHandlers(ViewMatchesPageUiHandlers homePageUiHandlers)
    {

    }

    public interface Binder extends UiBinder<Widget, ViewMatchesPageView>
    {
    }

    List<MatchData> objMatchData;

    public void setMatchesObject(List<MatchData> listMatches)
    {
        this.objMatchData = listMatches;
    }

    public void setMatches()
    {

        Widget panel = new org.gwtbootstrap3.client.ui.Panel();
        Widget panelHeader = new org.gwtbootstrap3.client.ui.PanelHeader();

        panelMatches.add(panel);
        panelMatches.add(panelHeader);

        //TODO: Trouver un moyen de fetcher les données de objMatchData et de les faire afficher

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