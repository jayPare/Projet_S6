/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.student.studentEditProfile;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.common.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.UserInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.UserInfoData;
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

public class studentEditProfilePagePagePresenter extends Presenter<studentEditProfilePagePagePresenter.MyView, studentEditProfilePagePagePresenter.MyProxy> implements studentEditProfilePageUiHandlers
{

    public static final Slot SLOT_USERS = new Slot();
    @Inject SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<studentEditProfilePageUiHandlers> {
        public void setUserInfosObject(UserInfoData objUserInfos);
        public void setUserInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.STUDENT_EDIT)
    //@UseGatekeeper(AuthentificationGatekeeper.class)
    public interface MyProxy extends ProxyPlace<studentEditProfilePagePagePresenter> {
    }

    @Inject
    public studentEditProfilePagePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        UserInfo objUserInfo = new UserInfo();
        objUserInfo.getStudent(1, true);
        dispatchAsync.execute(objUserInfo, userInfosAsyncCallback);
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

}