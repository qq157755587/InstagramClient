package com.zhaoyuanjie.instagramclient.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhaoyuanjie.instagramclient.databinding.MediaListItemBinding;
import com.zhaoyuanjie.instagramclient.models.Media;
import com.zhaoyuanjie.instagramclient.viewModels.MediaListItemViewModel;

/**
 * Created by zhaoyuanjie on 15/3/23.
 */
public class PopularMediasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Media[] mMedias;
    private Activity mActivity;

    public PopularMediasAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MediaListItemBinding binding = MediaListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MediaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MediaViewHolder vh = (MediaViewHolder) holder;
        Media media = mMedias[position];
        vh.binding.setMedia(new MediaListItemViewModel(mActivity, media));
    }

    @Override
    public int getItemCount() {
        return mMedias == null ? 0 : mMedias.length;
    }

    public void setMedias(Media[] medias) {
        mMedias = medias;
    }

    class MediaViewHolder extends RecyclerView.ViewHolder {
        MediaListItemBinding binding;

        public MediaViewHolder(MediaListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
