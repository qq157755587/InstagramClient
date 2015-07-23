package com.zhaoyuanjie.instagramclient.viewModels;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.zhaoyuanjie.instagramclient.MediaDetailActivity;
import com.zhaoyuanjie.instagramclient.R;
import com.zhaoyuanjie.instagramclient.models.Media;

/**
 * Created by zhaoyuanjie on 15/7/22.
 */
public class MediaListItemViewModel extends BaseObservable {
    private Activity mActivity;
    private Media mMedia;

    public MediaListItemViewModel(Activity activity, Media media) {
        mActivity = activity;
        mMedia = media;
    }

    public String getCaption() {
        if (mMedia.caption != null) {
            return mMedia.caption.text;
        }
        return null;
    }

    public String getImageStandardResolutionUrl() {
        return mMedia.images.standard_resolution.url;
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, MediaDetailActivity.class);
                intent.putExtra("url", mMedia.images.standard_resolution.url);
                String transName = mActivity.getString(R.string.shared_element_image);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
                                v, transName);
                ActivityCompat.startActivity(mActivity, intent, options.toBundle());
            }
        };
    }
}
