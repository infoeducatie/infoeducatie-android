package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Browsing on 7/9/2015.
 */
public class Talk implements Serializable {
    private String title;

    private String location;

    private String description;

    private Timestamp date;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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
