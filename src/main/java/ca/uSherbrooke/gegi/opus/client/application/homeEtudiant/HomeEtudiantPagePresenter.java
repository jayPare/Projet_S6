/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.homeEtudiant;

import javax.inject.Inject;

import ca.uSherbrooke.gegi.commons.core.client.accessRestriction.AuthenticationGatekeeper;
import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;

import ca.uSherbrooke.gegi.opus.client.application.LoggedInGatekeeper;
import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.*;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;

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

public class HomeEtudiantPagePresenter extends Presenter<HomeEtudiantPagePresenter.MyView, HomeEtudiantPagePresenter.MyProxy> implements HomeEtudiantPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject
    SideMenuPresenter sideMenuPresenter;
    @Inject
    DispatchAsync dispatchAsync;


    @Override
    public void actionOnDislike(int nStagiaireID) {
        MatchInfo match = new MatchInfo();
        //TODO use the good stagiaireID which should be from the gatekeeper instead of 1
        match.saveStudentMatch(true, 1, nStagiaireID, false);
        dispatchAsync.execute(match, matchInfosAsyncCallback);
    }

    @Override
    public void actionOnLike(int nStagiaireID) {
        MatchInfo match = new MatchInfo();
        //TODO use the good stagiaireID which should be from the gatekeeper  instead of 1
        match.saveStudentMatch(true, 1, nStagiaireID, true);
        dispatchAsync.execute(match, matchInfosAsyncCallback);
    }

    @Override
    public void actionOnRefresh() {
        getNextStagiaire();
    }

    public interface MyView extends View, HasUiHandlers<HomeEtudiantPageUiHandlers> {
        public void setUserInfosObject(UserInfoData objUserInfos);

        public void setUserInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    //@UseGatekeeper(LoggedInGatekeeper.class)
    public interface MyProxy extends ProxyPlace<HomeEtudiantPagePresenter> {
    }

    @Inject
    public HomeEtudiantPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        getNextStagiaire();
    }

    private AsyncCallback<UserInfoResult> userInfosAsyncCallback = new AsyncCallback<UserInfoResult>() {
        @Override
        public void onSuccess(UserInfoResult result) {
            getView().setUserInfosObject(result.getUserInfosObject());
            getView().setUserInfos();
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    private AsyncCallback<MatchInfoResult> matchInfosAsyncCallback = new AsyncCallback<MatchInfoResult>() {
        @Override
        public void onSuccess(MatchInfoResult result) {
            getNextStagiaire();
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    public void getNextStagiaire() {
        UserInfo objUserInfo = new UserInfo();
        objUserInfo.getNextStudent(true);
        dispatchAsync.execute(objUserInfo, userInfosAsyncCallback);
    }
}

