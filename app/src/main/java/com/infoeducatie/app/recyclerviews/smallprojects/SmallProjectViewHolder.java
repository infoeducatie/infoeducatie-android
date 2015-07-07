package com.infoeducatie.app.recyclerviews.smallprojects;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.infoeducatie.app.R;
import com.infoeducatie.app.helpers.FontHelper;
import com.infoeducatie.app.ui.CircularImageView;
import com.infoeducatie.app.ui.RoundedImageView;

/**
 * Created by Browsing on 7/7/2015.
 */
public class SmallProjectViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView title;
    public TextView participants;
    public TextView countycategory;

    public SmallProjectViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.item_project_small_image);
        title = (TextView) itemView.findViewById(R.id.item_project_small_title);
        participants = (TextView) itemView.findViewById(R.id.item_project_small_participants);
        countycategory = (TextView) itemView.findViewById(R.id.item_project_small_city_category);
        /* set the typefaces */
        title.setTypeface(FontHelper.LATO_REGULAR);
        participants.setTypeface(FontHelper.LATO_REGULAR);
        countycategory.setTypeface(FontHelper.LATO_REGULAR);
    }
}
