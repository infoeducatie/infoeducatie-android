
package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.util.List;

public class Current implements Serializable{
   	private Edition edition;
   	private boolean is_logged_in;
   	private Registration registration;

   	private User user;

 	public Edition getEdition(){
		return this.edition;
	}
	public void setEdition(Edition edition){
		this.edition = edition;
	}
 	public boolean getIs_logged_in(){
		return this.is_logged_in;
	}
	public void setIs_logged_in(boolean is_logged_in){
		this.is_logged_in = is_logged_in;
	}
 	public Registration getRegistration(){
		return this.registration;
	}
	public void setRegistration(Registration registration){
		this.registration = registration;
	}

 	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
}
