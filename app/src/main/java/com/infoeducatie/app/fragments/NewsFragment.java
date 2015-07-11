package com.infoeducatie.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.News;
import com.infoeducatie.app.helpers.AsyncTaskHelper;
import com.infoeducatie.app.helpers.UIMessageHelper;
import com.infoeducatie.app.recyclerviews.news.NewsAdapter;
import com.infoeducatie.app.service.management.NewsManagement;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private News[] mNews = new News[0];

    private NewsAdapter mAdapter;
    private View.OnClickListener newsOnClickListener;
    private RecyclerView mRecycler;

    public void setNewsOnClickListener(View.OnClickListener newsOnClickListener) {
        this.newsOnClickListener = newsOnClickListener;
        if (mAdapter != null) {
            mAdapter.setOnClickListener(newsOnClickListener);
        }
    }

    public NewsFragment() {
        // Required empty public constructor
    }

    public void setNews(News[] mNews) {
        this.mNews = mNews;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        /* initialize the recycler view */
        mRecycler = (RecyclerView) view.findViewById(R.id.fragment_news_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new NewsAdapter();
        mAdapter.setNews(mNews);
        mAdapter.setOnClickListener(newsOnClickListener);
        mRecycler.setAdapter(mAdapter);
        /**/
        if (mNews.length == 0) {
            /* we don't want to refresh if we already have news, on fragment create view */
            refreshNews();
        }
        return view;
    }

    /* get the news from the server */
    private void refreshNews() {
        AsyncTaskHelper.create(new AsyncTaskHelper.AsyncMethods<News[]>() {
            @Override
            public News[] doInBackground() {
                return NewsManagement.getAllNews();
            }

            @Override
            public void onDone(News[] value, long ms) {
                gotNews(value);

            }


        });
    }

    private void gotNews(News[] newses) {
        if (newses == null) {
            UIMessageHelper.showNetworkErrorMessage(getActivity());

            return;
        }
        mNews = newses;
        mAdapter.setNews(mNews);
    }


}
