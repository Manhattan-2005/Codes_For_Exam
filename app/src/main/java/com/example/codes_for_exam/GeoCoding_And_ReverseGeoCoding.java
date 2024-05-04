/*

Explain Geocoding and Reverse Geocoding with suitable example.

 */


package com.example.codes_for_exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class GeoCoding_And_ReverseGeoCoding extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_coding);

        initializeMap();
        Button revGeocodeButton = findViewById(R.id.reverse_geocode);

        revGeocodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText addEditText = findViewById(R.id.address);
                String name = addEditText.getText().toString();

                Geocoder geoCoder = new Geocoder(GeoCoding_And_ReverseGeoCoding.this);
                try {
                    List<Address> addresses = geoCoder.getFromLocationName(name, 1);
                    if(addresses.size() > 0) {
                        String res = "Latitude: " + addresses.get(0).getLatitude() + "\nLongitude: " +  addresses.get(0).getLongitude();
                        Toast.makeText(GeoCoding_And_ReverseGeoCoding.this, res, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GeoCoding_And_ReverseGeoCoding.this, "No location found for given address!", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }

    private void initializeMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.setOnMapClickListener(GeoCoding_And_ReverseGeoCoding.this);
    }

    @Override
    public void onMapClick(LatLng latLng) {

        if (marker != null) {
            marker.remove();
        }
        marker = mMap.addMarker(new MarkerOptions().position(latLng).title("Selected"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        Geocoder geocoder = new Geocoder(GeoCoding_And_ReverseGeoCoding.this);
        try {
            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

            if (addresses!= null && addresses.size() > 0) {
                String addressName = addresses.get(0).getAddressLine(0);
                Toast.makeText(GeoCoding_And_ReverseGeoCoding.this, "Location: " + addressName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(GeoCoding_And_ReverseGeoCoding.this, "No address found for clicked location", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeMap();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}