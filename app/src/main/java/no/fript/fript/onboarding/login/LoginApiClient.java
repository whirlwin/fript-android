package no.fript.fript.onboarding.login;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import no.fript.fript.BuildConfig;
import no.fript.fript.LogConstants;
import no.fript.fript.api.PathConstants;
import no.fript.fript.api.RequestQueueProvider;

public final class LoginApiClient {

    private final RequestQueue queue;

    public LoginApiClient() {
        this.queue = RequestQueueProvider.getQueue();
    }

    public void handleLogin(final FacebookLoginRequest facebookLoginRequest,
                            final Response.Listener<JSONObject> successCallback,
                            final Response.ErrorListener errorCallback) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + PathConstants.GET_ACCOUNT;
        final JSONObject json = new JSONObject();
        try {
            json.put("loginToken", facebookLoginRequest.getLoginToken());
            json.put("userId", facebookLoginRequest.getLoginToken());
            final JsonObjectRequest request =
                    new JsonObjectRequest(Request.Method.POST, url, json, successCallback, errorCallback);
            queue.add(request);
        } catch (final JSONException e) {
            Log.e(LogConstants.FACEBOOK_LOGIN, "Failed to log in user due to JSON error", e);
        }
    }
}
