package com.infoeducatie.app.recyclerviews.talks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Talk;

/**
 * Created by Browsing on 7/7/2015.
 */
public class TalksAdapter extends RecyclerView.Adapter<TalksViewHolder> {

    private Talk[] talks = new Talk[0];

    /* getters and setters for the news */
    public void setTalks(Talk[] talks) {
        this.talks = talks;
        notifyDataSetChanged();
    }

    public Talk[] getNews() {
        return talks;
    }

    /* */
    @Override
    public TalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* create the view holder */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_talk, null);
        TalksViewHolder viewHolder = new TalksViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final TalksViewHolder holder, final int position) {
     /* bind the viewholder item */


        holder.title.setText(talks[position].getTitle());
        holder.body.setText(talks[position].getDescription());
        holder.location.setText(talks[position].getLocation());
        holder.date.setText(talks[position].getDate());
        if (talks[position].getUser() != null) {
            // we have a user
            String person = talks[position].getUser().getFirst_name() + " " + talks[position].getUser().getLast_name();
            if (talks[position].getUser().getJob() != null && talks[position].getUser().getJob().length() > 0) {
                // we also have a job
                person += ", " + talks[position].getUser().getJob();
            }
            holder.person.setText(person);

        }

    }


    @Override
    public int getItemCount() {
        return talks.length;
    }
}
