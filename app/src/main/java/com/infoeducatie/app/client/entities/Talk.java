package com.infoeducatie.app.client.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Browsing on 7/9/2015.
 */
public class Talk implements Serializable {
    private String title;

    private String location;

    private String description;

    private Timestamp date;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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


    @Override
    public String toString() {
        return "ClassPojo [title = " + title + ", location = " + location + ", description = " + description + ", date = " + date + "]";
    }
}
