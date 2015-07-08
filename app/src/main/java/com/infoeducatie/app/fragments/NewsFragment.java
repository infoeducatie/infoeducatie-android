package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.News;
import com.infoeducatie.app.recyclerviews.news.NewsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private News[] mNews = new News[0];

    private NewsAdapter mAdapter;
    private RecyclerView mRecycler;

    public NewsFragment() {
        // Required empty public constructor
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
        mRecycler.setAdapter(mAdapter);
        /**/
        refreshNews();
        return view;
    }

    private void refreshNews() {

    }


}
