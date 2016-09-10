package no.fript.fript.onboarding.login;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.facebook.AccessToken;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

public final class LoginService {

    private final LoginApiClient loginApiClient;


    public LoginService() {
        this.loginApiClient = new LoginApiClient();
    }

    public void handleLogin(final LoginResult loginResult) {
        final AccessToken accessToken = loginResult.getAccessToken();
        final String token = accessToken.getToken();
        final String userId = accessToken.getUserId();
        final FacebookLoginRequest facebookLoginRequest = new FacebookLoginRequest(token, userId);
        loginApiClient.handleLogin(facebookLoginRequest, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {

            }
        });
    }
}

