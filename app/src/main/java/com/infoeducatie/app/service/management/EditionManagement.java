package com.infoeducatie.app.service.management;



import com.infoeducatie.app.client.entities.Current;
import com.infoeducatie.app.service.ServiceLocator;

public class EditionManagement {
	/* returns the current edition data */
	public static Current getEdition() {
		return ServiceLocator.getInstance().getClient().doGetRequest("current.json", Current.class);
	}

	
}
