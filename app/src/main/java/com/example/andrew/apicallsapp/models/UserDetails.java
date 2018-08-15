package com.example.andrew.apicallsapp.models;

public class UserDetails {
    private String status;
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetails(String status, User user) {

        this.status = status;
        this.user = user;
    }
}
