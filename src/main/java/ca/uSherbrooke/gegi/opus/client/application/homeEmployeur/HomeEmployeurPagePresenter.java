/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.commons.core.client.accessRestriction.AuthenticationGatekeeper;
import ca.uSherbrooke.gegi.opus.client.application.LoggedInGatekeeper;
import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfoResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.presenter.slots.Slot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

public class HomeEmployeurPagePresenter extends Presenter<HomeEmployeurPagePresenter.MyView, HomeEmployeurPagePresenter.MyProxy> implements HomeEmployeurPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject
    SideMenuPresenter sideMenuPresenter;
    @Inject
    DispatchAsync dispatchAsync;

    @Override
    public void actionOnDislike(int nEmployeurID) {
        MatchInfo match = new MatchInfo();
        //TODO use the good stagiaireID which should be from the gatekeeper instead of 1
        match.saveEmployerMatch(true, nEmployeurID, 1, false);
        dispatchAsync.execute(match, matchInfosAsyncCallback);
    }

    @Override
    public void actionOnLike(int nEmployeurID) {
        MatchInfo match = new MatchInfo();
        //TODO use the good stagiaireID which should be from the gatekeeper  instead of 1
        match.saveEmployerMatch(true, nEmployeurID, 1, true);
        dispatchAsync.execute(match, matchInfosAsyncCallback);
    }

    @Override
    public void actionOnRefresh() {
        getNextEmployer();
    }

    public interface MyView extends View, HasUiHandlers<HomeEmployeurPageUiHandlers> {
        public void setEmployerInfosObject(EmployerData objEmployerInfos);

        public void setEmployerInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.EMPLOYEUR)
    //@UseGatekeeper(AuthentificationGatekeeper.class)
    public interface MyProxy extends ProxyPlace<HomeEmployeurPagePresenter> {
    }

    @Inject
    public HomeEmployeurPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        getNextEmployer();
    }

    private AsyncCallback<EmployerInfoResult> employerInfosAsyncCallback = new AsyncCallback<EmployerInfoResult>() {
        @Override
        public void onSuccess(EmployerInfoResult result) {
            getView().setEmployerInfosObject(result.getEmployerInfosObject());
            getView().setEmployerInfos();
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    private AsyncCallback<MatchInfoResult> matchInfosAsyncCallback = new AsyncCallback<MatchInfoResult>() {
        @Override
        public void onSuccess(MatchInfoResult result) {
            getNextEmployer();
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    public void getNextEmployer() {
        EmployerInfo objEmployerInfo = new EmployerInfo();
        objEmployerInfo.getNextEmployer(true);
        dispatchAsync.execute(objEmployerInfo, employerInfosAsyncCallback);
    }
}