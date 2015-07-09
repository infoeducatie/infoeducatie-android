package com.infoeducatie.app.service.management;


import com.infoeducatie.app.Client;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.client.entities.ProjectCategory;
import com.infoeducatie.app.service.ServiceLocator;

import java.util.ArrayList;
import java.util.List;


public class ProjectsManagement {

    /* returns an array of all projects */
    public static Project[] getAllProjects() {
        return ServiceLocator.getInstance().getClient().doGetRequest("projects.json", Project[].class);
    }

    /*
     * this method will filter the array of projects and only return the ones
     * specified in the parameter
     */
    public static Project[] filterProjects(Project[] projects,
                                           ProjectCategory category) {
        if (category == ProjectCategory.all) {
            return projects;
        }
        /* create a list, and later switch it to an array */
        List<Project> projectsList = new ArrayList<Project>();
        for (Project project : projects) {
            if (project.getCategory() == category) {
                projectsList.add(project);
            }
        }
        Project[] result = new Project[projectsList.size()];
        projectsList.toArray(result);
        return result;

    }

    /* this method will return a string with all the participants */
    public static String getParticipantsFromProject(Project project) {
        if (project.getContestants().size() == 1) {
            return project.getContestants().get(0).getName();
        }
        /* if we have more than 1 contestant, add them all into a string, separated by ',' */
        String result = project.getContestants().get(0).getName();
        for (int i = 1; i < project.getContestants().size(); i++) {
            result += ", " + project.getContestants().get(i).getName();
        }
        return result;
    }

    /* this method will return the county and category in one string */
    public static String getCountyAndCategoryString(Project project) {
        /* make the first letter uppercase */
        String category = project.getCategory().name().charAt(0) + "";
        category = category.toUpperCase();
        category = category + project.getCategory().name().substring(1, project.getCategory().name().length());
        return project.getCounty() + " / " + category;
    }

    
}
