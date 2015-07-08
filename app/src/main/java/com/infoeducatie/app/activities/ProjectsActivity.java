package com.infoeducatie.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.ProjectCategory;
import com.infoeducatie.app.fragments.ProjectsFragment;

public class ProjectsActivity extends ActionBarActivity {

    private ProjectsFragment mProjectsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        mProjectsFragment = (ProjectsFragment) getSupportFragmentManager().findFragmentById(R.id.activity_projects_projects_fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_projects, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

      
        /* when the user clicks the settings */
        if (id == R.id.action_all) {
            mProjectsFragment.filterProjects(ProjectCategory.all);
        }
        if (id == R.id.action_robots) {
            mProjectsFragment.filterProjects(ProjectCategory.roboti);
        }
        if (id == R.id.action_web) {
            mProjectsFragment.filterProjects(ProjectCategory.web);
        }
        if (id == R.id.action_educational) {
            mProjectsFragment.filterProjects(ProjectCategory.educational);
        }
        if (id == R.id.action_utilitar) {
            mProjectsFragment.filterProjects(ProjectCategory.utilitar);
        }
        if (id == R.id.action_media) {
            mProjectsFragment.filterProjects(ProjectCategory.multimedia);
        }
 

        return super.onOptionsItemSelected(item);
    }
}
