package com.infoeducatie.app.recyclerviews.horizontalimages;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.infoeducatie.app.R;

/**
 * Created by Browsing on 7/7/2015.
 */
public class HorizontalImagesViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;


    public HorizontalImagesViewHolder(View itemView) {
        super(itemView);

        image = (ImageView) itemView.
                findViewById(R.id.item_image_image);


    }
}
