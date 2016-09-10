package no.fript.fript.onboarding.gymtype;

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
import no.fript.fript.api.PathConstants;
import no.fript.fript.api.RequestQueueProvider;

public final class GymTypeApiClient {

    private final RequestQueue queue;

    public GymTypeApiClient() {
        this.queue = RequestQueueProvider.getQueue();
    }

    public void getGymTypes(final Response.Listener<JSONArray> successCallback,
                            final Response.ErrorListener errorCallback) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + PathConstants.GYM_TYPE;
        final JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, url, null, successCallback, errorCallback);
        queue.add(request);
    }

    public void createGymTypePreference(final CreateGymTypePreference createGymTypePreference,
                                        final Response.Listener<JSONObject> successCallback,
                                        final Response.ErrorListener errorListener) {
        final String url = BuildConfig.FRIPT_API_BASE_URL + PathConstants.GYM_TYPE;
        try {
            final JSONObject json = new JSONObject();
            json.put("gymTypeId", createGymTypePreference.getGymTypeId());
            final JsonObjectRequest request =
                    new JsonObjectRequest(Request.Method.POST, url, json, successCallback, errorListener);
            queue.add(request);
        } catch (final JSONException e) {
            Log.e(LogConstants.GYM_TYPE_PREFERENCE, "Failed to create gym type preference due to JSON error", e);
        }
    }
}
