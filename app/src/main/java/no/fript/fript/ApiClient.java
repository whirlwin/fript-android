package no.fript.fript;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public final class ApiClient {

    private static final String API_BASE_URL = "http://192.168.0.104:4000/";

    private static ApiClient instance;
    private static RequestQueue queue;

    ApiClient(Activity activity) {
        queue = Volley.newRequestQueue(activity);
        //queue = new RequestQueue(new NoCache(), new BasicNetwork(new HurlStack()));
    }

    public void getActiveUsers(final Response.Listener<JSONArray> resCallback,
                               final Response.ErrorListener errCallback) {
        final String url = getApiBaseUrl() + "active-user";
        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, resCallback, errCallback);
        queue.add(request);
        int i;
    }

    private String getApiBaseUrl() {
        return API_BASE_URL;
    }

    public static ApiClient getInstance(Activity activity) {
        if (instance == null) {
            instance = new ApiClient(activity);
        }
        return instance;
    }
}
