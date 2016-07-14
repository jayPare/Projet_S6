/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.viewMatches;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfos;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfosResult;
import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
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
import java.util.List;


public class ViewMatchesPagePresenter extends Presenter<ViewMatchesPagePresenter.MyView, ViewMatchesPagePresenter.MyProxy> implements ViewMatchesPageUiHandlers {

    public static final Slot SLOT_USERS = new Slot();
    @Inject SideMenuPresenter sideMenuPresenter;
    @Inject DispatchAsync dispatchAsync;

    @Override
    public void displayUserInfo(Integer groupId) {
    }

    public interface MyView extends View, HasUiHandlers<ViewMatchesPageUiHandlers> {
        public void setMatchesObject(List<MatchData> objEmployerInfos);
        public void setMatches();
    }

    @ProxyStandard
    @NameToken(NameTokens.MATCHES)
	/*@UseGatekeeper(AuthenticationGatekeeper.class)*/
    public interface MyProxy extends ProxyPlace<ViewMatchesPagePresenter> {
    }

    @Inject
    public ViewMatchesPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        //TODO: Verifier si employeur ou etudiant
        MatchInfos objMatches = new MatchInfos();
        objMatches.getMatchEmployer(1, true);
        dispatchAsync.execute(objMatches, MatchInfosResultAsyncCallback);
    }

    private AsyncCallback<MatchInfosResult> MatchInfosResultAsyncCallback = new AsyncCallback<MatchInfosResult>() {
        @Override
        public void onSuccess(MatchInfosResult result)
        {
            getView().setMatchesObject(result.getMatchInfosObject());
            getView().setMatches();
        }
        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Les informations de l'employeur est inaccessible.");
        }
    };

}