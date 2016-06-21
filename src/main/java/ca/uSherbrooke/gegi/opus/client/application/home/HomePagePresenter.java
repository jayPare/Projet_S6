/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.home;

import javax.inject.Inject;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;

import ca.uSherbrooke.gegi.opus.client.application.home.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetEmployerInfosResult;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
import ca.uSherbrooke.gegi.opus.shared.entity.EmployerData;
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

import static com.google.gwt.query.client.GQuery.console;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> implements HomePageUiHandlers{

    public static final Slot SLOT_USERS = new Slot();
    @Inject SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<HomePageUiHandlers> {
        public void setUserInfosObject(UserInfosData objUserInfos);
        public void setEmployerInfosObject(EmployerData objEmployerInfos);
        public void setUserInfos();
        public void setEmployerInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
	/*@UseGatekeeper(AuthenticationGatekeeper.class)*/
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    public HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        GetUserInfos objUserInfo = new GetUserInfos();
        objUserInfo.setCIP("degs2601");
        dispatchAsync.execute(objUserInfo, getUserInfosAsyncCallback);
        
        GetEmployerInfos objEmployerInfo = new GetEmployerInfos();
        objEmployerInfo.setEmployerID(123);
        dispatchAsync.execute(objEmployerInfo, getEmployerInfosAsyncCallback);
    }

    private AsyncCallback<GetUserInfosResult> getUserInfosAsyncCallback = new AsyncCallback<GetUserInfosResult>() {
        @Override
        public void onSuccess(GetUserInfosResult result) {
            getView().setUserInfosObject(result.getUserInfosObject());
            getView().setUserInfos();
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Les informations de l'utilisateur est inaccessible.");
        }
    };
    private AsyncCallback<GetUserInfosResult> setUserInfosAsyncCallback = new AsyncCallback<GetUserInfosResult>() {
        @Override
        public void onSuccess(GetUserInfosResult result) {
            if(result.getSaveSuccess() == true){
                console.log("Enregistrement effectuée avec succès");
            }else{
                console.log("Enregistrement échouée");
            }
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Les informations de l'utilisateur n'a bien été enregistrées...");
        }
    };

    private AsyncCallback<GetEmployerInfosResult> getEmployerInfosAsyncCallback = new AsyncCallback<GetEmployerInfosResult>() {
        @Override
        public void onSuccess(GetEmployerInfosResult result) {
            getView().setEmployerInfosObject(result.getEmployerInfosObject());
            getView().setEmployerInfos();
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Les informations de l'employeur est inaccessible.");
        }
    };

    private AsyncCallback<GetEmployerInfosResult> setEmployerInfosAsyncCallback = new AsyncCallback<GetEmployerInfosResult>() {
        @Override
        public void onSuccess(GetEmployerInfosResult result) {
            if(result.getSaveSuccess() == true){
                console.log("Enregistrement effectuée avec succès");
            }else{
                console.log("Enregistrement échouée");
            }
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Les informations de l'employeur n'a bien été enregistrées...");
        }
    };
}