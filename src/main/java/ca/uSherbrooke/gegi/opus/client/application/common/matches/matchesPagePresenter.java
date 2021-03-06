/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opus.client.application.common.matches;

import ca.uSherbrooke.gegi.commons.core.client.presenter.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.commons.core.client.utils.AsyncCallbackFailed;
import ca.uSherbrooke.gegi.opus.client.application.common.sideMenu.SideMenuPresenter;
import ca.uSherbrooke.gegi.opus.client.place.NameTokens;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfo;
import ca.uSherbrooke.gegi.opus.shared.dispatch.MatchInfoResult;
import ca.uSherbrooke.gegi.opus.shared.entity.MatchData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;
import java.util.List;


public class matchesPagePresenter extends Presenter<matchesPagePresenter.MyView, matchesPagePresenter.MyProxy> implements matchesPageUiHandlers
{

    @Inject
    SideMenuPresenter sideMenuPresenter;
    @Inject
    DispatchAsync dispatchAsync;
    boolean bIsEmployer = true;

    @Override
    public void actionOnRefresh() {
        getMatches();
    }

    public interface MyView extends View, HasUiHandlers<matchesPageUiHandlers> {
        public void setMatchesObject(List<MatchData> objEmployerInfos);

        public void setMatches(boolean bIsEmployer);
    }

    @ProxyStandard
    @NameToken(NameTokens.MATCHES)
    //@UseGatekeeper(AuthentificationGatekeeper.class)
    public interface MyProxy extends ProxyPlace<matchesPagePresenter> {
    }

    @Inject
    public matchesPagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        sideMenuPresenter.getView().addToApplicationPresenter();
        sideMenuPresenter.refreshList();

        //TODO: Verifier si employeur ou etudiant
        getMatches();
    }

    public void getMatches() {
        if (bIsEmployer == true) { // If stagaire
            MatchInfo objMatches = new MatchInfo();
            objMatches.getMatchStudent(1, true);
            dispatchAsync.execute(objMatches, MatchInfosResultAsyncCallback);
        } else {
            MatchInfo objMatches = new MatchInfo();
            objMatches.getMatchEmployer(3, true);
            dispatchAsync.execute(objMatches, MatchInfosResultAsyncCallback);
        }
    }

    private AsyncCallback<MatchInfoResult> MatchInfosResultAsyncCallback = new AsyncCallback<MatchInfoResult>() {
        @Override
        public void onSuccess(MatchInfoResult result) {
            getView().setMatchesObject(result.getMatchInfosObject());
            getView().setMatches(bIsEmployer);
        }

        @Override
        public void onFailure(Throwable throwable) {
            AsyncCallbackFailed.asyncCallbackFailed(throwable, "Les informations de l'employeur est inaccessible.");
        }
    };

}