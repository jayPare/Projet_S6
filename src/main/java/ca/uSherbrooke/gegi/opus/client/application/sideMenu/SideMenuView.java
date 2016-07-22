/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.sideMenu;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.shared.entity.Data;
import ca.uSherbrooke.gegi.commons.core.shared.utils.Sort;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.UnorderedList;

import javax.inject.Inject;
import java.util.List;

public class SideMenuView extends ViewWithUiHandlers<SideMenuUiHandlers> implements SideMenuPresenter.MyView {

	private final Widget widget;

	@UiField HTMLPanel panelMenu;
	@UiField UnorderedList ulMenuContent;
	@UiField ListBox listBoxSort;
	@UiField TextBox textBoxFilter;
	@UiField Div ulSidebarEtudiant;
	@UiField Div ulSidebarEmployeur;
	@UiField Div ulSidebarMatches;

	@Inject ApplicationPresenter applicationPresenter;
	
	public interface Binder extends UiBinder<Widget, SideMenuView> {
    }

    @Inject
    public SideMenuView(Binder uiBinder) {
		widget = uiBinder.createAndBindUi(this);

		listBoxSort.addItem(Sort.LATEST_FIRST.toString(), Sort.LATEST_FIRST.toString());
		listBoxSort.addItem(Sort.ALPHABETICAL.toString(), Sort.ALPHABETICAL.toString());
		//listBoxSort.addItem(Sort.MOST_LIKED.toString(), Sort.MOST_LIKED.toString());
		listBoxSort.addItem(Sort.OLDEST_FIRST.toString(), Sort.OLDEST_FIRST.toString());

		listBoxSort.setSelectedIndex(1);
    }

	public void addToApplicationPresenter(){
		applicationPresenter.getView().addToSlot(ApplicationPresenter.SLOT_SIDE_MENU, panelMenu);
		applicationPresenter.getView().addToSlot(ApplicationPresenter.SLOT_SIDEBAR, ulSidebarEtudiant);
		applicationPresenter.getView().addToSlot(ApplicationPresenter.SLOT_SIDEBAR, ulSidebarEmployeur);
		applicationPresenter.getView().addToSlot(ApplicationPresenter.SLOT_SIDEBAR, ulSidebarMatches);
	}
	
	public void setList(List<Data> listData){
		AnchorListItem a;

		ulMenuContent.clear();

		if(listData != null){
			for(Data d : listData){
				a = new AnchorListItem();
				a.setText(d.getLabel());

				ulMenuContent.add(a);
			}
		}
	}

}