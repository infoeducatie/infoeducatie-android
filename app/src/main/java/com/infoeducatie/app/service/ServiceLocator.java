package com.infoeducatie.app.service;

import com.infoeducatie.app.BuildConfig;
import com.infoeducatie.app.client.main.Client;


/**
 * Created by Browsing on 7/7/2015.
 */
public class ServiceLocator {

    public static final String URL_DEBUG = "http://api.dev.infoeducatie.ro/v1/";
    public static final String URL_RELEASE = "http://api.infoeducatie.ro/v1/";
    public static String URL_ROOT = "-";
    private static ServiceLocator serviceLocator;

    public static ServiceLocator getInstance() {
        if (serviceLocator == null) {
            URL_ROOT = BuildConfig.DEBUG ? URL_DEBUG : URL_RELEASE;
            serviceLocator = new ServiceLocator();
        }
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
