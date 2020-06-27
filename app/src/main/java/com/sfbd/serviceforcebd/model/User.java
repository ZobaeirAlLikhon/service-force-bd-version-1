package com.sfbd.serviceforcebd.model;

import java.io.Serializable;

public class User implements Serializable {

    private String pushID;
    private String name;
    private String email;
    private String phone;
    private String userID;

    public User() {
    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String pushID, String name, String email, String phone, String userID) {
        this.pushID = pushID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userID = userID;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "pushID='" + pushID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
