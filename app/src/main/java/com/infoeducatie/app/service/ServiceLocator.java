package com.infoeducatie.app.service;

import com.infoeducatie.app.Client;

/**
 * Created by Browsing on 7/7/2015.
 */
public class ServiceLocator {

    public static String URL_ROOT = "http://api.infoeducatie.ro/v1/";
    private static ServiceLocator serviceLocator;

    public static ServiceLocator getInstance() {
        if (serviceLocator == null)
            serviceLocator = new ServiceLocator();
        return serviceLocator;
    }

    /* this class will hold the Client object */
    private Client client;

    public Client getClient() {
        return client;
    }

    public ServiceLocator() {
        client = new Client();
        client.setHomeURL(URL_ROOT);
    }
}
