package no.fript.fript.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import no.fript.fript.BuildConfig;
import no.fript.fript.CreateGymTypePreference;
import no.fript.fript.LogConstants;

public final class GymTypeService {

    private final RequestQueue queue;

    public GymTypeService(final RequestQueue queue) {
        this.queue = queue;
    }

    public void getGymTypes(final Response.Listener<JSONArray> successCallback,
                            final Response.ErrorListener errorCallback) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + PathConstants.GYM_TYPE;
        final JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, url, null, successCallback, errorCallback);
        queue.add(request);
    }

    public void createGymTypePreference(final CreateGymTypePreference createGymTypePreference,
                                        final Responte.Listener<JSONObject> successCallback,
                                        final Response.ErrorListener errorListener) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + PathConstants.GYM_TYPE;
        try {
            final JSONObject json = createGymTypePreference.toJSONObject();
            final JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST, url, json, successCallback, errorListener);
            queue.add(request);
        } catch (final JSONException e) {
            Log.e(LogConstants.GYM_TYPE_PREFERENCE, "Failed to create gym type preference", e);
        }
    }
}
