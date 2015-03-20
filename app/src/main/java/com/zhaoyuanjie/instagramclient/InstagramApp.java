package com.zhaoyuanjie.instagramclient;

import android.app.Application;

import com.zhaoyuanjie.instagramclient.network.VolleySingleton;

/**
 * Created by zhaoyuanjie on 15-3-15.
 */
public class InstagramApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        VolleySingleton.initial(this);
    }
}
