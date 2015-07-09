package com.infoeducatie.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Current;
import com.infoeducatie.app.client.entities.News;
import com.infoeducatie.app.helpers.AsyncTaskHelper;
import com.infoeducatie.app.helpers.FontHelper;
import com.infoeducatie.app.service.management.EditionManagement;
import com.infoeducatie.app.service.management.NewsManagement;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    /* views */
    private TextView mMotto;
    private TextView mParticipantsNumber;
    private TextView mProjectsNumber;
    private TextView mCountiesNumber;
    private TextView mEditionNumber;
    private TextView mParticipantsTitle;
    private TextView mCountiesTitle;
    private TextView mProjectsTitle;
    private TextView mTitle;
    private TextView mNewsButton;
    private View mTableRoot;

    /* other */
    private HomeFragmentListener homeFragmentListener;
    private News[] mNews;

    public HomeFragment() {
        // Required empty public constructor
    }

    public void setOnHomeFragmentListener(HomeFragmentListener homeFragmentListener) {
        this.homeFragmentListener = homeFragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //  load the views
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mMotto = (TextView) view.findViewById(R.id.fragment_home_motto);
        mParticipantsNumber = (TextView) view.findViewById(R.id.fragment_home_participants_number);
        mProjectsNumber = (TextView) view.findViewById(R.id.fragment_home_projects_number);
        mCountiesNumber = (TextView) view.findViewById(R.id.fragment_home_counties_number);
        mEditionNumber = (TextView) view.findViewById(R.id.fragment_home_edition);
        mProjectsTitle = (TextView) view.findViewById(R.id.fragment_home_projects_title);
        mParticipantsTitle = (TextView) view.findViewById(R.id.fragment_home_participants_title);
        mCountiesTitle = (TextView) view.findViewById(R.id.fragment_home_counties_title);
        mTitle = (TextView) view.findViewById(R.id.fragment_home_title);
        mNewsButton = (TextView) view.findViewById(R.id.fragment_home_news_button);
        mTableRoot = view.findViewById(R.id.fragment_home_table_layout);
        /* set fonts */
        mMotto.setTypeface(FontHelper.SHADOWS_INTO_LIGHT);
        mParticipantsNumber.setTypeface(FontHelper.LATO_BOLD);
        mProjectsNumber.setTypeface(FontHelper.LATO_BOLD);
        mCountiesNumber.setTypeface(FontHelper.LATO_BOLD);
        mEditionNumber.setTypeface(FontHelper.LATO_LIGHT);
        mProjectsTitle.setTypeface(FontHelper.LATO_REGULAR);
        mParticipantsTitle.setTypeface(FontHelper.LATO_REGULAR);
        mCountiesTitle.setTypeface(FontHelper.LATO_REGULAR);
        mTitle.setTypeface(FontHelper.SHADOWS_INTO_LIGHT);
        mNewsButton.setTypeface(FontHelper.ROBOTO_BOLD);

        /* events */
        mNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeFragmentListener != null) {
                    homeFragmentListener.onNewsClicked(mNews);
                }
            }
        });
        mTableRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeFragmentListener != null) {
                    homeFragmentListener.onStartProjects();
                }
            }
        });


        loadInfo();
        loadNews();
        return view;
    }

    /* called when we want to load the current edition info */
    private void loadInfo() {
        AsyncTaskHelper.create(new AsyncTaskHelper.AsyncMethods<Current>() {

            @Override
            public Current doInBackground() {
                return EditionManagement.getEdition();
            }

            @Override
            public void onDone(Current value, long ms) {
                gotInfo(value);
            }
        });
    }

    /* load the news in order to display the news button */
    private void loadNews() {
        AsyncTaskHelper.create(new AsyncTaskHelper.AsyncMethods<News[]>() {

            @Override
            public News[] doInBackground() {
                return NewsManagement.getAllNews();
            }

            @Override
            public void onDone(News[] value, long ms) {
                /* we got our news */
                mNews = value;
                if (value != null && value.length > 0) {
                    // we have news
                    if (getActivity() != null) {
                        mNewsButton.setText(getActivity().getString(R.string.msg_news_caps) + " (" + value.length + ")");
                        mNewsButton.setVisibility(View.VISIBLE);
                    }
                } else {
                    // no news
                    mNewsButton.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void gotInfo(Current value) {
        if (value == null) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.msg_con_error), Toast.LENGTH_SHORT).show();
        } else {
            // we got the current edition successfully
            mEditionNumber.setText(getActivity().getString(R.string.msg_edition) + " " + value.getEdition().getName());
            mMotto.setText(value.getEdition().getMotto());
            mCountiesNumber.setText(value.getStats().getTotal_counties() + "");
            mParticipantsNumber.setText(value.getStats().getTotal_participants() + "");
            mProjectsNumber.setText(value.getStats().getTotal_projects() + "");
        }
    }


    public static interface HomeFragmentListener {
        public void onNewsClicked(News[] news);

        public void onStartProjects();

        public void onStartTalks();
    }
}
