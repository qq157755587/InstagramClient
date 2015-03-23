package com.zhaoyuanjie.instagramclient.network;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zhaoyuanjie.instagramclient.models.Popular;

/**
 *
 * Created by zhaoyuanjie on 15/3/20.
 */
public class InstagramRestful {

    private static final String END_POINT = "https://api.instagram.com/v1";
    private static final String CLIENT_ID = "?client_id=c247327361234e128688cfcf5a3d5533";

    private static final String MEDIA_POPULAR = "/media/popular";

    private static Response.ErrorListener sErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("network error", error.getMessage());
        }
    };

    public static void mediaPopular(Response.Listener<Popular> listener) {
        String url = END_POINT + MEDIA_POPULAR + suffix();
        GsonRequest<Popular> request = new GsonRequest<>(url, Popular.class, null, listener, sErrorListener);
        VolleySingleton.getInstance().addToRequestQueue(request);
    }

    private static String suffix() {
        return CLIENT_ID;
    }
}
