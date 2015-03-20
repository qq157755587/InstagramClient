package com.zhaoyuanjie.instagramclient.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.zhaoyuanjie.instagramclient.R;
import com.zhaoyuanjie.instagramclient.network.InstagramRestful;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 * Created by zhaoyuanjie on 15-3-15.
 */
public class MediaListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_list, container, false);
        ButterKnife.inject(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onRefresh() {
        InstagramRestful.mediaPopular(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("popular", response);
            }
        });
    }
}
