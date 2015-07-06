package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infoeducatie.app.R;

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

    public HomeFragment() {
        // Required empty public constructor
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
        return view;
    }


}
