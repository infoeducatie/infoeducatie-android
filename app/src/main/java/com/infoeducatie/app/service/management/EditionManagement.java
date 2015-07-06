package com.infoeducatie.app.service.management;

import com.infoeducatie.app.Client;

import com.infoeducatie.app.client.entities.Current;
import com.infoeducatie.app.service.ServiceLocator;

public class EditionManagement {
	/* returns the current edition data */
	public static Current getEdition() {
		return ServiceLocator.getInstance().getClient().doGetRequest("current.json", Current.class);
	}

	/* example */
	public static void main(String[] args) {
		Client client = new Client();
		client.setHomeURL("http://api.dev.infoeducatie.ro/v1/");
		Current current = getEdition();
		System.out.println(current.getStats().getTotal_participants());
	}
}
