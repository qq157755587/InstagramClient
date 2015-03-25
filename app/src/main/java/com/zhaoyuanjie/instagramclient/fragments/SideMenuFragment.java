package com.zhaoyuanjie.instagramclient.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoyuanjie.instagramclient.LoginActivity;
import com.zhaoyuanjie.instagramclient.MainActivity;
import com.zhaoyuanjie.instagramclient.R;
import com.zhaoyuanjie.instagramclient.network.InstagramRestful;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 *
 * Created by zhaoyuanjie on 15/3/12.
 */
public class SideMenuFragment extends Fragment {
    private static final int REQUEST_CODE_LOGIN = 10;

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_LOGIN) {
            //todo
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.account)
    public void login() {
        ((MainActivity) getActivity()).closeDrawer();
        if (!InstagramRestful.isAuthenticated()) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, REQUEST_CODE_LOGIN);
        }
    }
}
