/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfosResult;
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

import static com.google.gwt.query.client.GQuery.console;

public class EditProfileEmployeurPagePresenter extends Presenter<EditProfileEmployeurPagePresenter.MyView, EditProfileEmployeurPagePresenter.MyProxy> implements EditProfileEmployeurPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject
    SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<EditProfileEmployeurPageUiHandlers> {
        public void setUserInfosObject(UserInfosData objUserInfos);
        public void setUserInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.EMPLOYEUR_EDIT)
	/*@UseGatekeeper(AuthenticationGatekeeper.class)*/
    public interface MyProxy extends ProxyPlace<EditProfileEmployeurPagePresenter> {
    }

    @Inject
    public EditProfileEmployeurPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
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
}