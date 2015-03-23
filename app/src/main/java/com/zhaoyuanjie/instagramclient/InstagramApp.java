package com.zhaoyuanjie.instagramclient;

import android.app.Application;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.zhaoyuanjie.instagramclient.network.VolleySingleton;

/**
 * Created by zhaoyuanjie on 15-3-15.
 */
public class InstagramApp extends Application {
    private OkHttpClient mOkHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        mOkHttpClient = new OkHttpClient();
        VolleySingleton.initial(this, mOkHttpClient);
        Picasso picasso = new Picasso.Builder(this).downloader(new OkHttpDownloader(mOkHttpClient)).build();
        Picasso.setSingletonInstance(picasso);
    }
}
