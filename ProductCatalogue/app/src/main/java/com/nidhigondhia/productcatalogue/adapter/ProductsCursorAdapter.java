package com.nidhigondhia.productcatalogue.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nidhigondhia.productcatalogue.R;
import com.nidhigondhia.productcatalogue.database.DBHelper;
import com.nidhigondhia.productcatalogue.model.Product;

import java.util.ArrayList;

/**
 * Product adpater for recycler view
 * Created by NIDHI on 3/12/2016.
 */
public class ProductsCursorAdapter extends  RecyclerView.Adapter<ProductsCursorAdapter.ViewHolder> {

    private final ArrayList<Product> productsList;
    private Context mContext;
    public ProductsCursorAdapter(Context context) {
        mContext = context;
        productsList = new ArrayList<Product>(0);
    }
    // Set the products for your adapter
    public void setItems(final ArrayList<Product> products) {
        productsList.clear();
        productsList.addAll(products);
        notifyDataSetChanged();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView ivProductImg;
        TextView tvProductName;
        TextView tvProductPrice;
         ProgressBar mProgressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            tvProductName = (TextView) itemView.findViewById(R.id.tvProductName);
            tvProductPrice = (TextView) itemView.findViewById(R.id.tvProductPrice);
            ivProductImg = (ImageView) itemView.findViewById(R.id.ivProductImage);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.row_banner_progress);
        }
        private void bindItem(final Product product) {
            tvProductName.setText(String.valueOf(product.getName()));
            tvProductPrice.setText(String.valueOf(product.getPrice()));
            mProgressBar.setVisibility(View.VISIBLE);

            Glide.with(mContext)
                    .load(product.getImage_url())
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
                    .into(ivProductImg);
            ivProductImg.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_listing,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindItem(productsList.get(position));
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
