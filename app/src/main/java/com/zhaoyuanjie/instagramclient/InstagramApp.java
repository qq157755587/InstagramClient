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

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient okHttpClient = new OkHttpClient();
        VolleySingleton.initial(this, okHttpClient);
        Picasso picasso = new Picasso.Builder(this).downloader(new OkHttpDownloader(okHttpClient)).build();
        Picasso.setSingletonInstance(picasso);
    }
}
