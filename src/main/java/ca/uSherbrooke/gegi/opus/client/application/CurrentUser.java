package ca.uSherbrooke.gegi.opus.client.application;

import ca.uSherbrooke.gegi.commons.core.server.utils.UserSessionImpl;
import ca.uSherbrooke.gegi.opus.shared.dispatch.GetUserInfos;

import javax.servlet.http.HttpServletRequest;

import static com.google.web.bindery.requestfactory.server.RequestFactoryServlet.getThreadLocalRequest;

/**
 * Created by Genie on 10/juil./2016.
 */
public class CurrentUser {
    HttpServletRequest _request = getThreadLocalRequest();
    UserSessionImpl _session = new UserSessionImpl(_request);
    String _cip = _session.getAdministrativeUserId();


    public boolean IsLoggedIn() {
        return false;
    }
}
