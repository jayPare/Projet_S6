package ca.uSherbrooke.gegi.opus.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

/**
 * Created by Genie on 10/juil./2016.
 */

@DefaultGatekeeper
public class LoggedInGatekeeper implements Gatekeeper{
    private CurrentUser _currentUser;

    @Inject
    public LoggedInGatekeeper(CurrentUser currentUser)
    {
        this._currentUser = currentUser;
    }

    @Override
    public boolean canReveal()
    {
        return _currentUser.IsLoggedIn();
    }

}
