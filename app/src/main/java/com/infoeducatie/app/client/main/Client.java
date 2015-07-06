package com.infoeducatie.app.client.main;

import java.net.HttpURLConnection;

public class Client {
	/* url to the web service ex: http://api.dev.infoeducatie.ro/v1/ */
	private String homeURL;

	public void setHomeURL(String homeURL) {
		this.homeURL = homeURL;
	}

	public <T> T doGetRequest(String path, Class<T> type) {
		try {
			HttpURLConnection urlConnection = HttpHelper
					.createHttpUrlConnection(homeURL + path, "GET", null);
			String response = HttpHelper
					.readHttpUrlConnectionResponse(urlConnection);
			return HttpHelper.stringToObject(response, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
