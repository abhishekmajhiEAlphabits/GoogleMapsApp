package com.example.googlemapsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapMarkerActivity extends AppCompatActivity implements OnMapReadyCallback {

    private boolean mLocationPermissionGranted = false;
    private GoogleMap gMap;
    MarkerOptions place1, place2,place3;

    private FusedLocationProviderClient mFusedlocationProvideClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_marker);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);

        place1 = new MarkerOptions().position(new LatLng(22.01, 86)).title("Location1");
        place2 = new MarkerOptions().position(new LatLng(22, 86)).title("Location2");
        place3 = new MarkerOptions().position(new LatLng(22.02, 86)).title("Location3");


        // String url =getUrl(place1.getPosition(),place2.getPosition(),"driving");
        //new FetchURL
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;

        gMap.addMarker(place1);
        gMap.addMarker(place2);
        gMap.addMarker(place3);
        moveCamera(new LatLng(22, 86), 15f, "My Location");

    }

    private void moveCamera(LatLng latLng, float zoom, String title) {
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }
}