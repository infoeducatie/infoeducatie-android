package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.helpers.AsyncTaskHelper;
import com.infoeducatie.app.recyclerviews.smallprojects.SmallProjectAdapter;
import com.infoeducatie.app.service.management.ProjectsManagement;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment {


    private Project[] mAllProjects = new Project[0];
    private SmallProjectAdapter mAdapter;
    private RecyclerView mRecycler;

    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        /* initialize the recycler view */
        mRecycler = (RecyclerView) view.findViewById(R.id.fragment_projects_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new SmallProjectAdapter();
        mAdapter.setProjects(mAllProjects);
        mRecycler.setAdapter(mAdapter);
        /**/
        loadAllProjects();
        return view;
    }

    private void loadAllProjects() {
        AsyncTaskHelper.create(new AsyncTaskHelper.AsyncMethods<Project[]>() {
            @Override
            public Project[] doInBackground() {
                return ProjectsManagement.getAllProjects();
            }

            @Override
            public void onDone(Project[] value, long ms) {
                gotProjects(value);

            }


        });
    }

    private void gotProjects(Project[] projects) {
        if (projects == null) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.msg_con_error), Toast.LENGTH_SHORT).show();
            return;
        }
        mAllProjects = projects;
        mAdapter.setProjects(mAllProjects);
    }


}
