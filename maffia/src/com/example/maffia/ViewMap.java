package com.example.maffia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// what you find here traveller relies on the ancient webpage: http://www.androidhive.info/2013/08/android-working-with-google-maps-v2/
// the knowledge from this webpage is worth more than gold. 

public class ViewMap extends FragmentActivity {
	// latitude and longitude
    double latitude = 53.558;
    double longitude = 9.927;
    
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	
	// Google Map
    private GoogleMap googleMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_viewmap);

		try {
            // Loading map
            initilizeMap();
            // showing current location
            googleMap.setMyLocationEnabled(true); // false to disable
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
        
        //my location button
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
         
        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("I am in Hamburg.");
        
     // GREEN color icon
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
         
        // adding marker
        googleMap.addMarker(marker);
        
        // move the camera to a location with an animation
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(17.385044, 78.486671)).zoom(12).build();
 
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
	
	public void logout(View view) {
		Intent intent = new Intent(this, LogIn.class);
		startActivity(intent);
	}
}
