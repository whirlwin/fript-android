package no.fript.fript.map;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import no.fript.fript.R;

public final class MapController implements OnMapReadyCallback {

    private final Activity activity;

    private MapInitializer mapInitializer;
    private MapUserSynchronizer mapUserSynchronizer;
    private GoogleMap mMap;

    public MapController(final FragmentActivity activity) {
        this.activity = activity;

        final SupportMapFragment mapFragment = (SupportMapFragment) activity
                .getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        this.mMap = map;

        mapInitializer = new MapInitializer(activity, map);
        mapInitializer.initializeMap();

        mapUserSynchronizer = new MapUserSynchronizer(activity, mMap);
        mapUserSynchronizer.synchronizeActiveUsers();
    }
}
