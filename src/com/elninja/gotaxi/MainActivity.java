package com.elninja.gotaxi;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

     WebView myWebView = (WebView) findViewById(R.id.app_webview);
     WebSettings webSettings = myWebView.getSettings();



    // GPSTracker class
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        this.webSettings.setJavaScriptEnabled(true);
        this.myWebView.loadUrl("http://www.google.com");


    }
}
