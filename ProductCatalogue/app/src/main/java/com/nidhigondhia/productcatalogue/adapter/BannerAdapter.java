package com.nidhigondhia.productcatalogue.adapter;

import android.support.v4.view.PagerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nidhigondhia.productcatalogue.R;
import com.nidhigondhia.productcatalogue.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Base adpater for slider
 * Created by NIDHI on 3/13/2016.
 */
public class BannerAdapter extends PagerAdapter {
    private Activity _activity;
    private List<Product> _imagePaths;
    private LayoutInflater inflater;
    // constructor
    public BannerAdapter(Activity activity, ArrayList<Product> imagePaths) {
        this._activity = activity;
        this._imagePaths = imagePaths;
        inflater = (LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this._imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View viewLayout = inflater.inflate(R.layout.row_banner, container, false);
        final Product mBannerVo = _imagePaths.get(position);
        final String mUrl = mBannerVo.getImage_url();

        ImageView mImgBanner = (ImageView) viewLayout.findViewById(R.id.row_banner_image);
        final ProgressBar mProgressBar = (ProgressBar) viewLayout.findViewById(R.id.row_banner_progress);

        mProgressBar.setVisibility(View.VISIBLE);

        // Download image using Glide library
        Glide.with(_activity)
                    .load(mBannerVo.getFeature_image_url())
                    .fitCenter()
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            mProgressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            mProgressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })

                    .into(mImgBanner);
        mImgBanner.setVisibility(View.VISIBLE);
        container.addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

}
