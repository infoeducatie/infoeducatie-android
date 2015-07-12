package com.infoeducatie.app.recyclerviews.talks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Talk;
import com.infoeducatie.app.client.entities.User;
import com.infoeducatie.app.helpers.DateHelper;

import java.util.List;

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

    /* converts a list of users to string, ex: Nume Prenume, Job
                                                Nume2 Prenume2 Job
     */
    public String usersToString(List<User> users) {
        if (users == null) return null;
        String result = "";
        for (User user : users) {
            result += user.getFirst_name() + " " + user.getLast_name();
            if (user.getJob() != null && user.getJob().trim().length() > 0) {
                result += ", " + user.getJob();
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public void onBindViewHolder(final TalksViewHolder holder, final int position) {
     /* bind the viewholder item */


        Talk talk = talks[position];

        holder.title.setText(talk.getTitle());
        holder.body.setText(talk.getDescription());
        holder.location.setText(talk.getLocation());
        if (talk.getDate() != null) {
            holder.date.setText(DateHelper.ISOFormatToString(talk.getDate()));
        } else {
            holder.date.setText(null);

        }
        holder.person.setText(usersToString(talk.getUsers()));


    }


    @Override
    public int getItemCount() {
        return talks.length;
    }
}
