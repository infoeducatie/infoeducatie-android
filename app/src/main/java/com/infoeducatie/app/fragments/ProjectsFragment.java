package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.helpers.AsyncTaskHelper;
import com.infoeducatie.app.service.management.ProjectsManagement;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment {


    private Project[] mAllProjects;

    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        loadAllProjects();
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    private void loadAllProjects() {
        AsyncTaskHelper.create(new AsyncTaskHelper.AsyncMethods<Project[]>() {
            @Override
            public Project[] doInBackground() {
                return ProjectsManagement.getAllProjects();
            }

            @Override
            public void onDone(Project[] value, long ms) {
                if (value == null) {
                    Toast.makeText(getActivity(), "EROR", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAllProjects = value;
                String res = "";
                for (Project project : value) {
                    res += project.getTitle() + " ";
                }
                Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT).show();
            }


        });
    }


}
