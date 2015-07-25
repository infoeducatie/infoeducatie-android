package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infoeducatie.app.R;
import com.infoeducatie.app.helpers.FontHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment {

    private ImageView mHeader;
    private TextView mTitle;
    private TextView mContestants;
    private TextView mExtra;
    private TextView mDescriptionTitle, mTehnicalDescriptionTitle, mRequirementsTitle;
    private TextView mDescription, mTehnicalDescription, mRequirements;
    private View mGithubIcon, mHomeIcon, mForumIcon;

    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project, container, false);
        mHeader = (ImageView) view.findViewById(R.id.fragment_project_header);
        mTitle = (TextView) view.findViewById(R.id.fragment_project_title);
        mContestants = (TextView) view.findViewById(R.id.fragment_project_contestants);
        mExtra = (TextView) view.findViewById(R.id.fragment_project_extra);
        /* titles*/
        mDescriptionTitle = (TextView) view.findViewById(R.id.fragment_project_description_title);
        mTehnicalDescriptionTitle = (TextView) view.findViewById(R.id.fragment_project_tehnical_description_title);
        mRequirementsTitle = (TextView) view.findViewById(R.id.fragment_project_tehnical_requirements_title);
        /* bodies */
        mDescription = (TextView) view.findViewById(R.id.fragment_project_description_title);
        mTehnicalDescription = (TextView) view.findViewById(R.id.fragment_project_tehnical_description_title);
        mRequirements = (TextView) view.findViewById(R.id.fragment_project_tehnical_requirements_title);
        /* icons*/
        mGithubIcon = view.findViewById(R.id.fragment_project_icon_github);
        mHomeIcon = view.findViewById(R.id.fragment_project_icon_home);
        mForumIcon = view.findViewById(R.id.fragment_project_icon_forum);
        /* set the fonts */
        mTitle.setTypeface(FontHelper.SHADOWS_INTO_LIGHT);
        mContestants.setTypeface(FontHelper.ROBOTO_REGULAR);
        mExtra.setTypeface(FontHelper.ROBOTO_REGULAR);
        return view;
    }


}
