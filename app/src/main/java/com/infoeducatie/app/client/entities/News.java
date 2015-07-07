package com.infoeducatie.app.client.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Browsing on 7/7/2015.
 */
public class News implements Serializable {

    /* need this because of the keyword short
     * http://stackoverflow.com/questions/6258796/gson-java-reserved-keyword */
    @SerializedName("short")
    private String _short;

    private String id;

    private String body;

    private String title;

    private boolean pinned;

    private String created_at;

    public String get_Short() {
        return _short;
    }

    public void set_Short(String _short) {
        this._short = _short;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return android.text.Html.fromHtml(body).toString();
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ClassPojo [_short = " + _short + ", id = " + id + ", body = " + body + ", title = " + title + ", pinned = " + pinned + ", created_at = " + created_at + "]";
    }
}
