package com.infoeducatie.app.service.management;

import com.infoeducatie.app.client.entities.News;
import com.infoeducatie.app.service.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Browsing on 7/7/2015.
 */
public class NewsManagement {
    public News[] getAllNews() {
        return ServiceLocator.getInstance().getClient().doGetRequest("news.json", News[].class);
    }

    public News[] filterNews(News[] newsArray, boolean isPinned) {
         /* create a list, and later switch it to an array */
        List<News> newsList = new ArrayList<News>();
        for (News news : newsArray) {
            if (news.getPinned() == isPinned) {
                newsList.add(news);
            }
        }
        News[] result = new News[newsList.size()];
        newsList.toArray(result);
        return result;
    }
}
