package com.gmc.gloumobile;

import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearByPlacesData extends AsyncTask<Object , String , String>
        {
            String googlePlacesData;
            GoogleMap mMap;
            String Url;
            protected String doInBackground(Object... objects) {
                mMap = (GoogleMap) objects[0];
                Url = (String) objects[1];

                DowloadUrl dowloadUrl = new DowloadUrl();
                try {
                    googlePlacesData = dowloadUrl.readUrl(Url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return googlePlacesData;
            }
                @Override
                protected void onPostExecute(String s) {
                    List<HashMap<String, String>> nearbyPlaceList = null;
                    DataParser dataParser = new DataParser();
                    // nearbyPlaceList = DataParser.parse(s);
                    // showNearbyPlaces(nearbyPlaceList);
                }
                private void showNearByPlaces(List<HashMap <String , String>>
                        nearbyPlacesList)
                {
                    for (int i = 0; i < nearbyPlacesList.size(); i++)
                    {
          MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String , String > googlePlace = nearbyPlacesList.get(i);

            String placeName = googlePlace.get("place_name");
            String vicinity = googlePlace.get("vicinity");
            double lat = Double.parseDouble(googlePlace.get("lat"));
            double lng = Double.parseDouble(googlePlace.get("lng"));
           LatLng latLng = new LatLng(lat, lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : " + vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker
                    (BitmapDescriptorFactory.HUE_BLUE));

            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));


                    }
                }

        }
