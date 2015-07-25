package com.infoeducatie.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.infoeducatie.app.R;
import com.infoeducatie.app.fragments.ProjectFragment;

public class ProjectActivity extends ActionBarActivity {

    private ProjectFragment mProjectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        mProjectFragment = (ProjectFragment) getSupportFragmentManager().findFragmentById(R.id.activity_project_fragment);
    }


}
