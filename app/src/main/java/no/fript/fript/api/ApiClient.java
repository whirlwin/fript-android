package no.fript.fript.api;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import no.fript.fript.BuildConfig;

public final class ApiClient {

    private static ApiClient instance;
    private static RequestQueue queue;

    private ApiClient(final Activity activity) {
        queue = Volley.newRequestQueue(activity);
    }

    public void getActiveUsers(final Response.Listener<JSONArray> successCallback,
                               final Response.ErrorListener errorCallback) {
        getJsonArray(PathConstants.GET_ACTIVE_USERS, successCallback, errorCallback);
    }

    public void getGymTypes(final Response.Listener<JSONArray> successCallback,
                            final Response.ErrorListener errorCallback) {
        getJsonArray(PathConstants.GET_GYM_TYPE, successCallback, errorCallback);
    }

    private void getJsonArray(final String path,
                              final Response.Listener<JSONArray> successCallback,
                              final Response.ErrorListener errorCallback) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + path;
        final JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, url, null, successCallback, errorCallback);
        queue.add(request);
    }

    public static ApiClient getInstance(Activity activity) {
        if (instance == null) {
            instance = new ApiClient(activity);
        }
        return instance;
    }
}
