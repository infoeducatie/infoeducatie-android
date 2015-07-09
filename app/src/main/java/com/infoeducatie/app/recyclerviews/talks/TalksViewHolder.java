package com.infoeducatie.app.recyclerviews.talks;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.infoeducatie.app.R;
import com.infoeducatie.app.helpers.FontHelper;

/**
 * Created by Browsing on 7/7/2015.
 */
public class TalksViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView body;
    public TextView date;
    public TextView location;
    public TextView person;


    public TalksViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.item_talk_title);
        body = (TextView) itemView.findViewById(R.id.item_talk_body);
        date = (TextView) itemView.findViewById(R.id.item_talk_date);
        location = (TextView) itemView.findViewById(R.id.item_talk_location);
        person = (TextView) itemView.findViewById(R.id.item_talk_id);

        /* set the typefaces */
        title.setTypeface(FontHelper.LATO_REGULAR);
        body.setTypeface(FontHelper.LATO_REGULAR);
        date.setTypeface(FontHelper.LATO_REGULAR);
        location.setTypeface(FontHelper.LATO_REGULAR);
        person.setTypeface(FontHelper.LATO_REGULAR);


    }
}
