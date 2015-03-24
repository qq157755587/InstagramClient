package com.zhaoyuanjie.instagramclient.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhaoyuanjie.instagramclient.MediaDetailActivity;
import com.zhaoyuanjie.instagramclient.R;
import com.zhaoyuanjie.instagramclient.models.Media;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by zhaoyuanjie on 15/3/23.
 */
public class PopularMediasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Media[] mMedias;
    private Context mContext;

    public PopularMediasAdapter(Context context) {
        mContext = context;
    }

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
        vh.itemView.setTag(R.id.id_media_url, media.images.standard_resolution.url);
    }

    @Override
    public int getItemCount() {
        return mMedias == null ? 0 : mMedias.length;
    }

    public void setMedias(Media[] medias) {
        mMedias = medias;
    }

    class MediaViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.image) ImageView image;
        @InjectView(R.id.caption) TextView caption;

        public MediaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        @OnClick(R.id.image)
        public void mediaDetail(View view) {
            Intent intent = new Intent(mContext, MediaDetailActivity.class);
            intent.putExtra("url", (String) itemView.getTag(R.id.id_media_url));
            String transName = mContext.getString(R.string.shared_element_image);
            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext,
                            view, transName);
            ActivityCompat.startActivity((Activity) mContext, intent, options.toBundle());
        }
    }
}
