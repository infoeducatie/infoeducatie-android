package com.infoeducatie.app.recyclerviews.smallprojects;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.service.management.ProjectsManagement;
import com.squareup.picasso.Picasso;

/**
 * Created by Browsing on 7/7/2015.
 */
public class SmallProjectAdapter extends RecyclerView.Adapter<SmallProjectViewHolder> {

    private Project[] projects = new Project[0];
    private SmallProjectItemListener smallProjectItemListener;

    /* getters and setters for the projects */
    public void setProjects(Project[] projects) {
        this.projects = projects;
        notifyDataSetChanged();
    }

    public void setSmallProjectItemListener(SmallProjectItemListener smallProjectItemListener) {
        this.smallProjectItemListener = smallProjectItemListener;
    }

    public Project[] getProjects() {
        return projects;
    }

    /* */
    @Override
    public SmallProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* create the view holder */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_small, null);
        SmallProjectViewHolder viewHolder = new SmallProjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SmallProjectViewHolder holder, final int position) {
     /* bind the viewholder item */
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* we clicked a item */
                if (smallProjectItemListener != null) {
                    smallProjectItemListener.onProjectClicked(projects[position].getId());
                }
            }
        });
        holder.title.setText(projects[position].getTitle());
        holder.participants.setText(ProjectsManagement.getParticipantsFromProject(projects[position]));
        holder.countycategory.setText(ProjectsManagement.getCountyAndCategoryString(projects[position]));
        /* check if project has images */
        if (projects[position].getScreenshots() != null && projects[position].getScreenshots().length > 0) {
            /* there are images, load the first one */
            Picasso.with(holder.image.getContext())
                    .load(projects[position].getScreenshots()[0].getUrl())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(holder.image);
        } else {
            /* no images, empty the image view */
            holder.image.setImageResource(R.drawable.transparent);
        }
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    public static interface SmallProjectItemListener {
        public void onProjectClicked(int id);
    }
}
