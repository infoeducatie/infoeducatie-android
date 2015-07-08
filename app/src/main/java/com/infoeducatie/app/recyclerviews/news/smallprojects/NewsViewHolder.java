package com.infoeducatie.app.recyclerviews.news.smallprojects;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.infoeducatie.app.R;
import com.infoeducatie.app.helpers.FontHelper;

/**
 * Created by Browsing on 7/7/2015.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView body;


    public NewsViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.item_news_title);
        body = (TextView) itemView.findViewById(R.id.item_news_body);

        /* set the typefaces */
        title.setTypeface(FontHelper.LATO_REGULAR);
        body.setTypeface(FontHelper.LATO_REGULAR);


    }
}
