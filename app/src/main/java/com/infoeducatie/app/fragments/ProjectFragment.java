package com.infoeducatie.app.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infoeducatie.app.R;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.helpers.FontHelper;
import com.infoeducatie.app.service.management.ProjectsManagement;
import com.squareup.picasso.Picasso;

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

    private Project project;


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
        mDescription = (TextView) view.findViewById(R.id.fragment_project_description_content);
        mTehnicalDescription = (TextView) view.findViewById(R.id.fragment_project_tehnical_description_content);
        mRequirements = (TextView) view.findViewById(R.id.fragment_project_tehnical_requirements_content);
        /* icons*/
        mGithubIcon = view.findViewById(R.id.fragment_project_icon_github);
        mHomeIcon = view.findViewById(R.id.fragment_project_icon_home);
        mForumIcon = view.findViewById(R.id.fragment_project_icon_forum);
        /* set the fonts */
        mTitle.setTypeface(FontHelper.SHADOWS_INTO_LIGHT);
        mContestants.setTypeface(FontHelper.ROBOTO_REGULAR);
        mExtra.setTypeface(FontHelper.ROBOTO_REGULAR);
        mDescriptionTitle.setTypeface(FontHelper.ROBOTO_REGULAR);
        mTehnicalDescriptionTitle.setTypeface(FontHelper.ROBOTO_REGULAR);
        mRequirementsTitle.setTypeface(FontHelper.ROBOTO_REGULAR);
        mDescription.setTypeface(FontHelper.LATO_LIGHT);
        mTehnicalDescription.setTypeface(FontHelper.LATO_LIGHT);
        mRequirements.setTypeface(FontHelper.LATO_LIGHT);

        /* events */
        mGithubIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl(project.getSource_url());
            }
        });
        mHomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl(project.getHomepage());
            }
        });
        mForumIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl(project.getDiscourse_url());
            }
        });

        refreshIconsState();
        return view;
    }

    /* will reset the buttons state, visible / invisible */
    private void refreshIconsState() {
        if (mGithubIcon == null) return;
        if (project == null) {
            mGithubIcon.setVisibility(View.INVISIBLE);
            mForumIcon.setVisibility(View.INVISIBLE);
            mHomeIcon.setVisibility(View.INVISIBLE);
            return;
        }

        /* if we have the urls make them visible if not invisible */
        mGithubIcon.setVisibility((project.getSource_url() != null && project.getSource_url().length() > 0) ? View.VISIBLE : View.INVISIBLE);
        mForumIcon.setVisibility((project.getDiscourse_url() != null && project.getDiscourse_url().length() > 0) ? View.VISIBLE : View.INVISIBLE);
        mHomeIcon.setVisibility((project.getHomepage() != null && project.getHomepage().length() > 0) ? View.VISIBLE : View.INVISIBLE);

    }

    private void goToUrl(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    public void setProject(Project project) {
        if (mTitle == null) return;
        if (project == null) return;
        this.project = project;
        /* views or projects are null */
        mTitle.setText(project.getTitle());
        /* if we have screenshots */
        if (project.getScreenshots() != null && project.getScreenshots().length > 0) {
            Picasso.with(mTitle.getContext())
                    .load(project.getScreenshots()[0].getUrl())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(mHeader);
        }

        mContestants.setText(ProjectsManagement.getParticipantsFromProject(project).toUpperCase());
        mExtra.setText(ProjectsManagement.getCountyAndCategoryString(project).toUpperCase());
        mDescription.setText(project.getDescription());
        mTehnicalDescription.setText(project.getTechnical_description());
        mRequirements.setText(project.getSystem_requirements());
        refreshIconsState();


    }


}
