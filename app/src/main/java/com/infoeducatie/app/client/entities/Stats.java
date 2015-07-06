
package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.util.List;

public class Stats implements Serializable {
   	private Number total_counties;
   	private Number total_participants;
   	private Number total_projects;

 	public Number getTotal_counties(){
		return this.total_counties;
	}
	public void setTotal_counties(Number total_counties){
		this.total_counties = total_counties;
	}
 	public Number getTotal_participants(){
		return this.total_participants;
	}
	public void setTotal_participants(Number total_participants){
		this.total_participants = total_participants;
	}
 	public Number getTotal_projects(){
		return this.total_projects;
	}
	public void setTotal_projects(Number total_projects){
		this.total_projects = total_projects;
	}
}
