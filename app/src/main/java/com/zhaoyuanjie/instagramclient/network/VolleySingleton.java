package com.zhaoyuanjie.instagramclient.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

/**
 *
 * Created by zhaoyuanjie on 15/3/20.
 */
public class VolleySingleton {
    private static VolleySingleton sInstance;
    private RequestQueue mRequestQueue;
    private Context mCtx;
    private OkHttpClient mOkHttpClient;

    private VolleySingleton(Context context, OkHttpClient okHttpClient) {
        mCtx = context;
        mOkHttpClient = okHttpClient;
        mRequestQueue = getRequestQueue();
    }

    public static void initial(Context context, OkHttpClient okHttpClient) {
        if (sInstance == null) {
            sInstance = new VolleySingleton(context, okHttpClient);
        }
    }

    public static VolleySingleton getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("VolleySingleton didn't initial!");
        }
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext(), new OkHttpStack(mOkHttpClient));
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
