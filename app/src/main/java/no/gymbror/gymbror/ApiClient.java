package no.gymbror.gymbror;

import android.app.Activity;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NoCache;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

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
