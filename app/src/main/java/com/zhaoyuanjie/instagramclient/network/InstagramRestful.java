package com.zhaoyuanjie.instagramclient.network;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zhaoyuanjie.instagramclient.models.MediaList;

/**
 *
 * Created by zhaoyuanjie on 15/3/20.
 */
public class InstagramRestful {

    private static final String END_POINT = "https://api.instagram.com/v1";
    private static final String CLIENT_ID = "?client_id=c247327361234e128688cfcf5a3d5533";
    private static final String TOKEN_KEY = "?access_token=";
    private static String sToken;

    private static final String MEDIA_POPULAR = "/media/popular";
    private static final String FEED = "/users/self/feed";

    private static Response.ErrorListener sErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("network error", error.getMessage() + "");
        }
    };

    public static void mediaPopular(Response.Listener<MediaList> listener) {
        String url = END_POINT + MEDIA_POPULAR + suffix();
        GsonRequest<MediaList> request = new GsonRequest<>(url, MediaList.class, null, listener, sErrorListener);
        VolleySingleton.getInstance().addToRequestQueue(request);
    }

    public static void feed(Response.Listener<MediaList> listener) {
        String url = END_POINT + FEED + suffix();
        GsonRequest<MediaList> request = new GsonRequest<>(url, MediaList.class, null, listener, sErrorListener);
        VolleySingleton.getInstance().addToRequestQueue(request);
    }

    public static String loginUrl() {
        return "https://instagram.com/oauth/authorize/"
                + CLIENT_ID + "&redirect_uri=http://localhost&response_type=token";
    }

    public static void setToken(String token) {
        sToken = token;
    }

    public static boolean isAuthenticated() {
        return sToken != null;
    }

    public void logout() {
        sToken = null;
    }

    private static String suffix() {
        if (isAuthenticated()) {
            return TOKEN_KEY + sToken;
        }
        return CLIENT_ID;
    }
}
