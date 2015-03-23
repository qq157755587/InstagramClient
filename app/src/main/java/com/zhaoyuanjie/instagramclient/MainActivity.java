package com.zhaoyuanjie.instagramclient;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.zhaoyuanjie.instagramclient.fragments.MediaListFragment;
import com.zhaoyuanjie.instagramclient.fragments.SideMenuFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 * Created by zhaoyuanjie on 15/3/12.
 */
public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @InjectView(R.id.toolbar) Toolbar mToolbar;

    private SideMenuFragment mSideMenuFragment;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setupListener();
        addMediaListFragment();
    }

    private void initViews() {
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.Primary_Blue_Grey_800));
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mToggle);

        mSideMenuFragment = ((SideMenuFragment) getFragmentManager().findFragmentById(R.id.fragment_side_menu));
    }

    private void setupListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
                    mDrawerLayout.closeDrawer(Gravity.START);
                } else {
                    mDrawerLayout.openDrawer(Gravity.START);
                }
            }
        });
    }

    private void addMediaListFragment() {
        MediaListFragment mediaListFragment = new MediaListFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_main, mediaListFragment).commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }
}
