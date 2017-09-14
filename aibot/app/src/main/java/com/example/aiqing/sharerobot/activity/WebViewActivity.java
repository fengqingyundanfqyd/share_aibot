package com.example.aiqing.sharerobot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.aiqing.sharerobot.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebMyAibot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initFindId();
        initData();
    }

    private void initFindId() {
        mWebMyAibot = (WebView) findViewById(R.id.webview_myaibot);

    }

    private void initData() {
        WebSettings settings = mWebMyAibot.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultTextEncodingName("UTF-8");
        mWebMyAibot.loadUrl("https://shared.aqcome.com/#/userHelp");
        //mWebMyAibot.loadUrl("https://www.baidu.com/");

        mWebMyAibot.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebMyAibot.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {

            }
        });

    }
}
