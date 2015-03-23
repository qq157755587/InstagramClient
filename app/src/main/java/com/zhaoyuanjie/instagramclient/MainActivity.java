package com.zhaoyuanjie.instagramclient;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;

import com.zhaoyuanjie.instagramclient.fragments.MediaListFragment;
import com.zhaoyuanjie.instagramclient.fragments.SideMenuFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 * Created by zhaoyuanjie on 15/3/12.
 */
public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private SideMenuFragment mSideMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.Primary_Blue_Grey_800));

        mSideMenuFragment = ((SideMenuFragment) getFragmentManager().findFragmentById(R.id.fragment_side_menu));

        MediaListFragment mediaListFragment = new MediaListFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_main, mediaListFragment).commit();
    }
}
