package com.infoeducatie.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.fragments.ProjectFragment;
import com.infoeducatie.app.helpers.AsyncTaskHelper;
import com.infoeducatie.app.helpers.UIMessageHelper;
import com.infoeducatie.app.service.management.ProjectsManagement;

public class ProjectActivity extends ActionBarActivity {

    /* this activity must have a id for the project to load with the name 'id' inside the intent*/
    private ProjectFragment mProjectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        mProjectFragment = (ProjectFragment) getSupportFragmentManager().findFragmentById(R.id.activity_project_fragment);


        final int projectId = getIntent().getIntExtra("id", -1);
        if (projectId == -1) {
            /* no project id */
            finish();
            return;
        }
        /* load the project */
        AsyncTaskHelper.create(new AsyncTaskHelper.AsyncMethods<Project>() {
            @Override
            public Project doInBackground() {
                return ProjectsManagement.getProject(projectId);
            }

            @Override
            public void onDone(Project project, long ms) {
                if (project == null) {
                    UIMessageHelper.showNetworkErrorMessage(ProjectActivity.this);
                } else {
                    /* we got the project! */
                    mProjectFragment.setProject(project);
                }
            }
        });

    }


}
