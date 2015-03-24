package com.zhaoyuanjie.instagramclient.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaoyuanjie.instagramclient.R;
import com.zhaoyuanjie.instagramclient.models.Media;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhaoyuanjie on 15/3/23.
 */
public class PopularMediasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Media[] mMedias;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_list_item, parent, false);
        return new MediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MediaViewHolder vh = (MediaViewHolder) holder;
        Media media = mMedias[position];
        Picasso.with(null).load(media.images.standard_resolution.url).into(vh.image);
        if (media.caption != null) {
            vh.caption.setText(media.caption.text);
        }
    }

    @Override
    public int getItemCount() {
        return mMedias == null ? 0 : mMedias.length;
    }

    public void setMedias(Media[] medias) {
        mMedias = medias;
    }

    static class MediaViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.image) ImageView image;
        @InjectView(R.id.caption) TextView caption;

        public MediaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
