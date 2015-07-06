
package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.util.List;

public class Screenshots implements Serializable {
   	private String url;

 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
}
