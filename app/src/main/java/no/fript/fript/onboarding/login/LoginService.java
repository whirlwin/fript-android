package no.fript.fript.onboarding.login;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.facebook.AccessToken;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

public final class LoginService {

    void handleLogin(final LoginResult loginResult) {
        final AccessToken accessToken = loginResult.getAccessToken();
        final String token = accessToken.getToken();
        final String userId = accessToken.getUserId();
        final FacebookLoginRequest facebookLoginRequest = new FacebookLoginRequest(token, userId);
    }
}

