package no.fript.fript.map;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import no.fript.fript.ApiClient;
import no.fript.fript.LogConstants;

public final class MapUserSynchronizer {

    private final Activity mActivity;
    private final GoogleMap mMap;

    public MapUserSynchronizer(final Activity activity, final GoogleMap map) {
        this.mActivity = activity;
        this.mMap = map;
    }

    public void synchronizeActiveUsers() {
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ApiClient.getInstance(mActivity).getActiveUsers(new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(final JSONArray response) {
                        populateMapWithActiveUsers(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(final VolleyError error) {
                        Log.e(LogConstants.GET_ACTIVE_USERS, "Failed to get active users", error);
                    }
                });
            }
        }, 0, 10000);
    }

    private void populateMapWithActiveUsers(final JSONArray activeUsers) {
        try {
            for(int i = 0; i < activeUsers.length(); i++) {
                addMarkerToMap(activeUsers.getJSONObject(i));
            }
        } catch (final JSONException e) {
            Toast.makeText(mActivity, "Failed to get active users:: " + e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    private void addMarkerToMap(final JSONObject object) {
        try {
            final double lat = object.getDouble("lat");
            final double lng = object.getDouble("lng");
            final LatLng latLng = new LatLng(lat, lng);
            final MarkerOptions options = new MarkerOptions();
            options.position(latLng);
            mMap.addMarker(options);
        } catch (final JSONException e) {
            Toast.makeText(mActivity, "Failed to place active user: " + e.getMessage(), Toast.LENGTH_SHORT);
        }
    }
}
