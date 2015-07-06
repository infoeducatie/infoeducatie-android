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

	/* example */
	public static void main(String[] args) {
		Client client = new Client();
		client.setHomeURL("http://api.dev.infoeducatie.ro/v1/");
		Project[] projects = getAllProjects();
		projects = filterProjects(projects, ProjectCategory.web);
		for (Project project : projects) {
			System.out.println(project.getCategory());
		}
	}
}
