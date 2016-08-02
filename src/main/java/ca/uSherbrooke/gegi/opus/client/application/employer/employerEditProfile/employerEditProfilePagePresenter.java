/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.employer.employerEditProfile;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.common.sideMenu.SideMenuPresenter;
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
import com.gwtplatform.mvp.client.presenter.slots.Slot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import javax.inject.Inject;
import java.util.List;

public class employerEditProfilePagePresenter extends Presenter<employerEditProfilePagePresenter.MyView, employerEditProfilePagePresenter.MyProxy> implements employerEditProfilePageUiHandlers
{
    public int _employerID;
    public static final Slot SLOT_USERS = new Slot();
    @Inject SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<employerEditProfilePageUiHandlers> {
        public void setEmployerInfosObject(EmployerData objEmployerInfos);
        public void setEmployerInfos();
        public void setEmployerInfoListObject(List<EmployerData> objEmployerInfos);
        public void populateDropdownEmployer();
    }


    @ProxyStandard
    @NameToken(NameTokens.EMPLOYER_EDIT)
    //@UseGatekeeper(AuthentificationGatekeeper.class)
    public interface MyProxy extends ProxyPlace<employerEditProfilePagePresenter> {
    }

    public void setPresenterEmployerID(int employerID)
    {
        _employerID = employerID;
    }

    private AsyncCallback<EmployerInfoResult> employerInfosAsyncCallback = new AsyncCallback<EmployerInfoResult>()
    {
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

    @Inject
    public employerEditProfilePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    public void getAllEmployer() {
        EmployerInfo emp = new EmployerInfo();
        emp.getAllEmployer(true);
        dispatchAsync.execute(emp, getAllEmployerAsyncCallback);
    }

    private AsyncCallback<EmployerInfoResult> getAllEmployerAsyncCallback = new AsyncCallback<EmployerInfoResult>()
    {
        @Override
        public void onSuccess(EmployerInfoResult result)
        {
            getView().setEmployerInfoListObject(result.getEmployerInfosListObject());
            getView().populateDropdownEmployer();
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Action n'a pas pu être effectuée");
        }
    };

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();

        sideMenuPresenter.refreshList();
        getAllEmployer();

        EmployerInfo objEmployerInfo = new EmployerInfo();
        //TODO: Aller chercher l'ID de l'employeur loggué
        objEmployerInfo.getEmployer(3, true);
        dispatchAsync.execute(objEmployerInfo, employerInfosAsyncCallback);
    }

}