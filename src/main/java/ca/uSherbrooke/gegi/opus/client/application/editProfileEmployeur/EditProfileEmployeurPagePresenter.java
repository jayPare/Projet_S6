/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.editProfileEmployeur;

import ca.uSherbrooke.gegi.commons.core.client.accessRestriction.AuthenticationGatekeeper;
import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.LoggedInGatekeeper;
import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.EmployerInfoResult;
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

public class EditProfileEmployeurPagePresenter extends Presenter<EditProfileEmployeurPagePresenter.MyView, EditProfileEmployeurPagePresenter.MyProxy> implements EditProfileEmployeurPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<EditProfileEmployeurPageUiHandlers> {
        public void setEmployerInfosObject(EmployerData objEmployerInfos);
        public void setEmployerInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.EMPLOYEUR_EDIT)
    //@UseGatekeeper(AuthentificationGatekeeper.class)
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

        EmployerInfo objEmployerInfo = new EmployerInfo();
        //TODO: Aller chercher l'ID de l'employeur loggué
        objEmployerInfo.getEmployer(1, true);
        dispatchAsync.execute(objEmployerInfo, employerInfosAsyncCallback);
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
}