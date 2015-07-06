
package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable {
   	private ProjectCategory category;
   	private List<Contestants> contestants;
   	private String county;
   	private Number discourse_comments_count;
   	private String discourse_url;
   	private Number id;
   	private List<Screenshots> screenshots;
   	private String title;

 	public ProjectCategory getCategory(){
		return this.category;
	}
	public void setCategory(ProjectCategory category){
		this.category = category;
	}
 	public List<Contestants> getContestants(){
		return this.contestants;
	}
	public void setContestants(List<Contestants> contestants){
		this.contestants = contestants;
	}
 	public String getCounty(){
		return this.county;
	}
	public void setCounty(String county){
		this.county = county;
	}
 	public Number getDiscourse_comments_count(){
		return this.discourse_comments_count;
	}
	public void setDiscourse_comments_count(Number discourse_comments_count){
		this.discourse_comments_count = discourse_comments_count;
	}
 	public String getDiscourse_url(){
		return this.discourse_url;
	}
	public void setDiscourse_url(String discourse_url){
		this.discourse_url = discourse_url;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public List<Screenshots> getScreenshots(){
		return this.screenshots;
	}
	public void setScreenshots(List<Screenshots> screenshots){
		this.screenshots = screenshots;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}
