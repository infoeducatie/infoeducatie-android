package com.infoeducatie.app.client.entities;

import java.io.Serializable;

/**
 * Created by Browsing on 7/9/2015.
 */
public class Talk implements Serializable {
    private String title;

    private String location;

    private String description;

    private String date;

    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ClassPojo [title = " + title + ", location = " + location + ", description = " + description + ", date = " + date + ", user = " + user + "]";
    }
}
