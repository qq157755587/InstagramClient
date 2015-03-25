package com.zhaoyuanjie.instagramclient;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhaoyuanjie.instagramclient.network.InstagramRestful;

import butterknife.InjectView;

/**
 * Created by zhaoyuanjie on 15/3/25.
 */
public class LoginActivity extends BaseActivity {
    private static final String token_key = "#access_token=";

    @InjectView(R.id.webview)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("url", url);
                if (url.contains(token_key)) {
                    int start = url.indexOf(token_key) + token_key.length();
                    String token = url.substring(start);
                    Log.e("token", token);
                    InstagramRestful.setToken(token);
                    setResult(RESULT_OK);
                    finish();
                } else {
                    view.loadUrl(url);
                }
                return true;
            }
        });
        mWebView.loadUrl(InstagramRestful.loginUrl());
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_login;
    }
}
