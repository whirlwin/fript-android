package no.fript.fript.map;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import no.fript.fript.permission.PermissionConstants;

public final class MapInitializer {

    private final Activity activity;
    private final GoogleMap mMap;

    public MapInitializer(final @NonNull Activity activity, final @NonNull GoogleMap map) {
        this.activity = activity;
        this.mMap = map;
    }

    public void initializeMap() {
        if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            handleZoomToCurrentLocation();
        } else {
            askForLocationPermission();
        }

    }

    private void handleZoomToCurrentLocation() throws SecurityException {
        final LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        final Criteria criteria = new Criteria();
        final String provider = locationManager.getBestProvider(criteria, true);
        final Location myLocation = locationManager.getLastKnownLocation(provider);
        final LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());

        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
    }

    private void askForLocationPermission() {
        ActivityCompat.requestPermissions(activity, new String[]{ android.Manifest.permission.ACCESS_COARSE_LOCATION },
                PermissionConstants.LOCATION_PERMISSION);
        ActivityCompat.requestPermissions(activity, new String[]{ android.Manifest.permission.ACCESS_FINE_LOCATION },
                PermissionConstants.LOCATION_PERMISSION);
    }
}
