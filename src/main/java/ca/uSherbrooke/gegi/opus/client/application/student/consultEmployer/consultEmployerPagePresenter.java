/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.student.consultEmployer;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.LoggedInGatekeeper;
import ca.uSherbrooke.gegi.opus.client.application.common.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.*;
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
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

public class consultEmployerPagePresenter extends Presenter<consultEmployerPagePresenter.MyView, consultEmployerPagePresenter.MyProxy> implements consultEmployerPageUiHandlers
{

    public int studentID = -1;

    @Inject
    SideMenuPresenter sideMenuPresenter;
    @Inject
    DispatchAsync dispatchAsync;

    @Override
    public void actionOnDislike(int nEmployeurID) {
        MatchInfo match = new MatchInfo();
        //TODO use the good stagiaireID which should be from the gatekeeper instead of 1
        if (studentID != -1)
        {
            match.saveEmployerMatch(true, nEmployeurID, studentID, false);
            dispatchAsync.execute(match, matchInfosAsyncCallback);
        }
        else
        {
            //TODO: Error
        }
    }

    @Override
    public void actionOnLike(int nEmployeurID) {
        MatchInfo match = new MatchInfo();
        if (studentID != -1)
        {
            match.saveEmployerMatch(true, nEmployeurID, studentID, true);
            dispatchAsync.execute(match, matchInfosAsyncCallback);
        }
        else
        {
            //TODO: Error
        }
        //TODO use the good stagiaireID which should be from the gatekeeper  instead of 1
    }

    @Override
    public void actionOnRefresh() {
        getNextEmployer();
    }

    public interface MyView extends View, HasUiHandlers<consultEmployerPageUiHandlers> {
        public void setEmployerInfosObject(EmployerData objEmployerInfos);

        public void setEmployerInfos();
    }

    @ProxyStandard
    @NameToken(NameTokens.CONSULT_EMPLOYER)
    @UseGatekeeper(LoggedInGatekeeper.class)
    public interface MyProxy extends ProxyPlace<consultEmployerPagePresenter> {
    }

    @Inject
    public consultEmployerPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();
        CurrentUserInfo user = new CurrentUserInfo();
        dispatchAsync.execute(user,connectedUserInfoAsyncCallback);
        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        getNextEmployer();
    }

    public void getNextEmployer() {
        EmployerInfo objEmployerInfo = new EmployerInfo();
        objEmployerInfo.getNextEmployer(true, studentID);
        dispatchAsync.execute(objEmployerInfo, employerInfosAsyncCallback);
    }

    private AsyncCallback<CurrentUserInfoResult> connectedUserInfoAsyncCallback = new AsyncCallback<CurrentUserInfoResult>() {
        @Override
        public void onSuccess(CurrentUserInfoResult result)
        {
            studentID = result.getUserID();
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

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
}