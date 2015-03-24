package com.zhaoyuanjie.instagramclient.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoyuanjie.instagramclient.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 *
 * Created by zhaoyuanjie on 15/3/12.
 */
public class SideMenuFragment extends Fragment {
    @InjectView(R.id.account) View mAccount;
    @InjectView(R.id.avatar) ImageView mAvatar;
    @InjectView(R.id.login) TextView mLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_side_menu, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.account)
    public void login() {
        Toast.makeText(getActivity(), "TODO login", Toast.LENGTH_SHORT).show();
    }
}
