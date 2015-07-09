
package com.infoeducatie.app.client.entities;

import java.io.Serializable;

public class User implements Serializable {
    private String first_name;

    private String last_name;

    private String job;

    private String email_md5;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail_md5() {
        return email_md5;
    }

    public void setEmail_md5(String email_md5) {
        this.email_md5 = email_md5;
    }

    @Override
    public String toString() {
        return "ClassPojo [first_name = " + first_name + ", last_name = " + last_name + ", job = " + job + ", email_md5 = " + email_md5 + "]";
    }
}
