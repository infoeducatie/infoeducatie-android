package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Current;
import com.infoeducatie.app.helpers.AsyncTaskHelper;
import com.infoeducatie.app.helpers.FontHelper;
import com.infoeducatie.app.service.management.EditionManagement;

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
        mProjectsTitle = (TextView) view.findViewById(R.id.fragment_home_projects_title);
        mParticipantsTitle = (TextView) view.findViewById(R.id.fragment_home_participants_title);
        mCountiesTitle = (TextView) view.findViewById(R.id.fragment_home_counties_title);
        mTitle = (TextView) view.findViewById(R.id.fragment_home_title);
        /* set fonts */
        mMotto.setTypeface(FontHelper.SHADOWS_INTO_LIGHT);
        mParticipantsNumber.setTypeface(FontHelper.ROBOTO_REGULAR);
        mProjectsNumber.setTypeface(FontHelper.ROBOTO_REGULAR);
        mCountiesNumber.setTypeface(FontHelper.ROBOTO_REGULAR);
        mEditionNumber.setTypeface(FontHelper.ROBOTO_REGULAR);
        mProjectsTitle.setTypeface(FontHelper.ROBOTO_REGULAR);
        mParticipantsTitle.setTypeface(FontHelper.ROBOTO_REGULAR);
        mCountiesTitle.setTypeface(FontHelper.ROBOTO_REGULAR);
        mTitle.setTypeface(FontHelper.SHADOWS_INTO_LIGHT);


        loadInfo();
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


}
