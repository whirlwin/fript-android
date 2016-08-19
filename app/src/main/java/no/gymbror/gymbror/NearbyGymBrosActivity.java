package no.gymbror.gymbror;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import no.gymbror.gymbror.map.MapController;
import no.gymbror.gymbror.permission.PermissionConstants;

public final class NearbyGymBrosActivity extends FragmentActivity /*implements OnMapReadyCallback*/ {

    private GoogleMap mMap;
    private MapController mapController;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nearby_gym_bros);

        this.mapController = new MapController(this);
        /*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        */
    }


    /*
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            handleZoomToCurrentLocation();
        } else {
            askForLocationPermission();
        }
    }
    */

    private void askForLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_COARSE_LOCATION },
                PermissionConstants.LOCATION_PERMISSION);
        ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION },
                PermissionConstants.LOCATION_PERMISSION);
    }

    private void handleZoomToCurrentLocation() throws SecurityException {
        final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final Criteria criteria = new Criteria();
        final String provider = locationManager.getBestProvider(criteria, true);
        final Location myLocation = locationManager.getLastKnownLocation(provider);
        final LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
        Toast.makeText(this, "current lat,lng:" + latLng.latitude + " " + latLng.longitude, Toast.LENGTH_SHORT).show();

        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode,
                                           final String permissions[],
                                           final int[] grantResults) {
        switch (requestCode) {
            case PermissionConstants.LOCATION_PERMISSION: {
                if (permissionWasGranted(grantResults)) {
                    handleZoomToCurrentLocation();
                } else {
                    Toast.makeText(this, "Current location needed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    private boolean permissionWasGranted(final int[] grantResults) {
        return grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED;
    }
}
