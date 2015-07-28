package com.infoeducatie.app.recyclerviews.horizontalimages;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Screenshot;
import com.squareup.picasso.Picasso;

/**
 * Created by Browsing on 7/7/2015.
 */
public class HorizontalImagesAdapter extends RecyclerView.Adapter<HorizontalImagesViewHolder> {


    private Screenshot[] screenshots = new Screenshot[0];


    /* getters and setters for the screenshots */

    public void setScreenshots(Screenshot[] screenshots) {
        this.screenshots = screenshots;
    }

    public Screenshot[] getScreenshots() {
        return screenshots;
    }

    /* */
    @Override
    public HorizontalImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* create the view holder */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, null);
        HorizontalImagesViewHolder viewHolder = new HorizontalImagesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HorizontalImagesViewHolder holder, final int position) {
     /* bind the viewholder item */

        Screenshot screenshot = screenshots[position];
        Picasso.with(holder.image.getContext())
                .load(screenshot.getUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(holder.image);

    }


    @Override
    public int getItemCount() {
        return screenshots.length;
    }


}
