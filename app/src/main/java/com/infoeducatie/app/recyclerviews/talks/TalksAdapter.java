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


        Talk talk = talks[position];

        holder.title.setText(talk.getTitle());
        holder.body.setText(talk.getDescription());
        holder.location.setText(talk.getLocation());
        if (talk.getDate() != null) {
            holder.date.setText(talk.getDate().toString());
        } else {
            holder.date.setText(null);

        }
        if (talk.getUser() != null) {
            // we have a user
            String person = talk.getUser().getFirst_name() + " " + talk.getUser().getLast_name();
            if (talk.getUser().getJob() != null && talk.getUser().getJob().length() > 0) {
                // we also have a job
                person += ", " + talk.getUser().getJob();
            }
            holder.person.setText(person);

        }

    }


    @Override
    public int getItemCount() {
        return talks.length;
    }
}
