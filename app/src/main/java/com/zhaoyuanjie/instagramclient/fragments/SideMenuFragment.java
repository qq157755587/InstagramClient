package com.zhaoyuanjie.instagramclient.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhaoyuanjie.instagramclient.R;

/**
 *
 * Created by zhaoyuanjie on 15/3/12.
 */
public class SideMenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_side_menu, container, false);

        return view;
    }
}
