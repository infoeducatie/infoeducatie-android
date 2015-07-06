
package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.util.List;

public class Edition implements Serializable {
   	private Number id;
   	private String motto;
   	private String name;
   	private Number year;

 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getMotto(){
		return this.motto;
	}
	public void setMotto(String motto){
		this.motto = motto;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getYear(){
		return this.year;
	}
	public void setYear(Number year){
		this.year = year;
	}
}
