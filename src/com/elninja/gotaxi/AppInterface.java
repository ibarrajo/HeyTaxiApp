package com.elninja.gotaxi;
import android.content.Context;
import android.widget.Toast;
//import android.webkit.JavascriptInterface;

public class AppInterface {
    Context mContext;

    // GPSTracker class
    GPSTracker gps;

    /** Instantiate the interface and set the context */
    AppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    //@JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }


    //@JavascriptInterface
    public String getLatitude() {
        gps = new GPSTracker(mContext);
        //Coordinates cor = new Coordinates();
         double latitude = 0;
        // check if GPS enabled
        if(gps.canGetLocation()){
            latitude = gps.getLatitude();
            //cor.setLongitude(gps.getLongitude());
        }else{
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
        return Double.toString(latitude);
    }

    //@JavascriptInterface
    public String getLongitude() {
        gps = new GPSTracker(mContext);
        //Coordinates cor = new Coordinates();
        double longitude = 0;
        // check if GPS enabled
        if(gps.canGetLocation()){
            longitude = gps.getLongitude();
            //cor.setLongitude(gps.getLongitude());
        }else{
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
        return Double.toString(longitude);
    }

    //@JavascriptInterface
    public String getCoordinates() {
        gps = new GPSTracker(mContext);
        //Coordinates cor = new Coordinates();
        String latitude = "0";
        String longitude = "0";
        // check if GPS enabled
        if(gps.canGetLocation()){
            latitude = Double.toString(gps.getLatitude());
            longitude = Double.toString(gps.getLongitude());
            //cor.setLongitude(gps.getLongitude());
        }else{
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
        return "{\"latitude\": " + latitude + ", \"longitude\": " + longitude + "}";
    }
}