package com.infoeducatie.app.service.management;

import com.infoeducatie.app.client.entities.Talk;
import com.infoeducatie.app.service.ServiceLocator;

/**
 * Created by Browsing on 7/9/2015.
 */
public class TalksManagement {
    public static Talk[] getAllTalks() {
        return ServiceLocator.getInstance().getClient().doGetRequest("talks.json", Talk[].class);
    }
}
