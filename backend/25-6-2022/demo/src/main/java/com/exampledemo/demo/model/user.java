package com.exampledemo.demo.model;

public class user {
    public user(String id, String fullname, String gender) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
    }

    public user() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String id;
    private String fullname;
    private String gender;
}
