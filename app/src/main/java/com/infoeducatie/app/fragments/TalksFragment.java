package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Talk;
import com.infoeducatie.app.recyclerviews.talks.TalksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TalksFragment extends Fragment {
    private Talk[] mTalks = new Talk[0];

    private TalksAdapter mAdapter;
    private RecyclerView mRecycler;

    public void setTalk(Talk[] mTalks) {
        this.mTalks = mTalks;
    }

    public TalksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_talks, container, false);

        /* initialize the recycler view */
        mRecycler = (RecyclerView) view.findViewById(R.id.fragment_talks_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TalksAdapter();
        mAdapter.setTalks(mTalks);
        mRecycler.setAdapter(mAdapter);
        /**/
        if (mTalks.length == 0) {
            /* we don't want to refresh if we already have news, on fragment create view */
            refreshTalks();
        }
        return view;
    }

    private void refreshTalks() {

    }


}
