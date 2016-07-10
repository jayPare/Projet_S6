/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.editProfileEtudiant.sideMenu.SideMenuPresenter;
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

public class EditProfileEtudiantPagePresenter extends Presenter<EditProfileEtudiantPagePresenter.MyView, EditProfileEtudiantPagePresenter.MyProxy> implements EditProfileEtudiantPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject
    SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<EditProfileEtudiantPageUiHandlers> {
        public void setUserInfosObject(UserInfosData objUserInfos);
        public void setUserInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.ETUDIANT_EDIT)
	/*@UseGatekeeper(AuthenticationGatekeeper.class)*/
    public interface MyProxy extends ProxyPlace<EditProfileEtudiantPagePresenter> {
    }

    @Inject
    public EditProfileEtudiantPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        GetUserInfos objUserInfo = new GetUserInfos();
        dispatchAsync.execute(objUserInfo, userInfosAsyncCallback);
    }

    private AsyncCallback<GetUserInfosResult> userInfosAsyncCallback = new AsyncCallback<GetUserInfosResult>() {
        @Override
        public void onSuccess(GetUserInfosResult result) {
            getView().setUserInfosObject(result.getUserInfosObject());
            getView().setUserInfos();
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

}