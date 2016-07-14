/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.inscriptionEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfosResult;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfosData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.Slot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

public class InscriptionEmployeurPagePresenter extends Presenter<InscriptionEmployeurPagePresenter.MyView, InscriptionEmployeurPagePresenter.MyProxy> implements InscriptionEmployeurPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject
    SideMenuPresenter sideMenuPresenter;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<InscriptionEmployeurPageUiHandlers> {
    }

    @ProxyStandard
    @NameToken(NameTokens.EMPLOYEUR_INSCRIPTION)
	/*@UseGatekeeper(AuthenticationGatekeeper.class)*/
    public interface MyProxy extends ProxyPlace<InscriptionEmployeurPagePresenter> {
    }

    @Inject
    public InscriptionEmployeurPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();
    }
}