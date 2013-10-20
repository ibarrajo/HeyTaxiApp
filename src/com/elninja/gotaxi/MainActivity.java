package com.elninja.gotaxi;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.app.ProgressDialog;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    // Initialize variables:
    WebView myWebView;
    WebSettings webSettings;


    // GPSTracker class
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        // if recovering from reload
        if (savedInstanceState != null) {
            ((WebView)findViewById(R.id.app_webview)).restoreState(savedInstanceState);
        }


        final ProgressDialog pd = ProgressDialog.show(this, "", "Starting the Awesome...",true);

        myWebView = (WebView) findViewById(R.id.app_webview);
        webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new AppInterface(this), "Android");
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if(pd.isShowing()&&pd!=null)
                {
                    pd.dismiss();
                }
            }
        });
        myWebView.loadUrl("http://gotaxi-elninja.rhcloud.com/app/");
    }


    protected void onSaveInstanceState(Bundle outState) {
        myWebView.saveState(outState);
    }
}
