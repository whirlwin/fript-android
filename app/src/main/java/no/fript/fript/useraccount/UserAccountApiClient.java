package no.fript.fript.useraccount;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.AccessToken;

import org.json.JSONObject;

import no.fript.fript.BuildConfig;
import no.fript.fript.api.PathConstants;
import no.fript.fript.api.RequestQueueProvider;

final class UserAccountApiClient {

    private static UserAccountApiClient instance;

    private final RequestQueue queue;

    private UserAccountApiClient() {
        this.queue = RequestQueueProvider.getQueue();
    }

    void getAccount(final AccessToken accessToken,
                    final Response.Listener<JSONObject> successCallback,
                    final Response.ErrorListener errorListener) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + PathConstants.GET_ACCOUNT;
        final JSONObject json = new JSONObject();
        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, json, successCallback, errorListener);
        queue.add(request);
    }

    public static UserAccountApiClient getInstance() {
        if (instance == null) {
            instance = new UserAccountApiClient();
        }
        return instance;
    }
}
