package com.zhaoyuanjie.instagramclient.network;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 *
 * Created by zhaoyuanjie on 15/3/20.
 */
public class InstagramRestful {

    private static final String HOST = "https://api.instagram.com/v1";
    private static final String CLIENT_ID = "?client_id=c247327361234e128688cfcf5a3d5533";

    private static final String MEDIA_POPULAR = "/media/popular";

    public static void mediaPopular(Response.Listener<String> listener) {
        StringRequest request = new StringRequest(HOST + MEDIA_POPULAR + suffix(),
                listener, null);
        VolleySingleton.getInstance().addToRequestQueue(request);
    }

    private static String suffix() {
        return CLIENT_ID;
    }
}
