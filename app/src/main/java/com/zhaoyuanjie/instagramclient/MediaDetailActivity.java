package com.zhaoyuanjie.instagramclient;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.InjectView;

/**
 * Created by zhaoyuanjie on 15/3/24.
 */
public class MediaDetailActivity extends BaseActivity {
    @InjectView(R.id.image) ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_media_detail;
    }

    private void initViews() {
        String url = getIntent().getStringExtra("url");
        Picasso.with(this).load(url).into(mImage);
    }
}
