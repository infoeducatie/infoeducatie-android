package com.infoeducatie.app.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.News;
import com.infoeducatie.app.fragments.NewsFragment;
import com.infoeducatie.app.fragments.WebViewDialogFragment;
import com.infoeducatie.app.recyclerviews.news.NewsAdapter;

public class NewsActivity extends ActionBarActivity {

    private NewsFragment mNewsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mNewsFragment = (NewsFragment) getSupportFragmentManager().findFragmentById(R.id.activity_news_fragment);
        mNewsFragment.setNewsOnClickListener(new NewsAdapter.NewsAdapterListener() {
            @Override
            public void onClick(News news) {
                if (news != null) {
                    /* we clicked a news item */
                    new WebViewDialogFragment().setHtml(news.getBody()).show(getSupportFragmentManager(), "tag");
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
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
}
