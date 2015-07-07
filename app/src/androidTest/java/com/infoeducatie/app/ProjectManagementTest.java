package com.infoeducatie.app;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.infoeducatie.app.client.entities.Contestants;
import com.infoeducatie.app.client.entities.Project;
import com.infoeducatie.app.client.entities.ProjectCategory;
import com.infoeducatie.app.service.management.ProjectsManagement;

import java.util.ArrayList;

/**
 * Created by Browsing on 7/7/2015.
 */
public class ProjectManagementTest extends ApplicationTestCase<Application> {

    public ProjectManagementTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    public void testGetParticipantsFromProject() {
        /* test when we have more than 1 contestant */
        Project project1 = new Project();
        project1.setContestants(new ArrayList<Contestants>());
        Contestants contestants1 = new Contestants();
        contestants1.setName("Ion");
        Contestants contestants2 = new Contestants();
        contestants2.setName("Dan");
        project1.getContestants().add(contestants1);
        project1.getContestants().add(contestants2);

        assertTrue(ProjectsManagement.getParticipantsFromProject(project1).equals("Ion, Dan"));

        /* test for only one contestant*/
        Project project2 = new Project();
        project2.setContestants(new ArrayList<Contestants>());
        project2.getContestants().add(contestants1);


        assertTrue(ProjectsManagement.getParticipantsFromProject(project2).equals("Ion"));
    }

    public void testGetCountyAndCategoryString() {
        Project project = new Project();
        project.setCounty("Brasov");
        project.setCategory(ProjectCategory.utilitar);
        assertTrue(ProjectsManagement.getCountyAndCategoryString(project).equals("Brasov / Utilitar"));
    }
}
