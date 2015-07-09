package com.infoeducatie.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.News;
import com.infoeducatie.app.fragments.HomeFragment;


public class HomeActivity extends ActionBarActivity implements HomeFragment.HomeFragmentListener {

    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.activity_home_home_fragment);
        mHomeFragment.setOnHomeFragmentListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNewsClicked(News[] news) {
        /* we clicked the news button , start news activity */
        Intent intent = new Intent(this, NewsActivity.class);
        intent.putExtra("mNews", news);
        startActivity(intent);
    }

    @Override
    public void onStartProjects() {
        Intent intent = new Intent(this, ProjectsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStartTalks() {

    }
}
