package utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zhaoyuanjie.instagramclient.views.SquareImageView;

/**
 * Created by zhaoyuanjie on 15/7/22.
 */
public class BindingUtil {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(SquareImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
