
package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.util.List;

public class Registration implements Serializable {
   	private Finished_projects finished_projects;
   	private Pending_project pending_project;

 	public Finished_projects getFinished_projects(){
		return this.finished_projects;
	}
	public void setFinished_projects(Finished_projects finished_projects){
		this.finished_projects = finished_projects;
	}
 	public Pending_project getPending_project(){
		return this.pending_project;
	}
	public void setPending_project(Pending_project pending_project){
		this.pending_project = pending_project;
	}
}
