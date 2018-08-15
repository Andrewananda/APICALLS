package com.example.andrew.apicallsapp.models;

public class User {
    private String email;
    private String name;
    private  String password;
    private String phone_number;
    private String api_token;

    public String getPhone_number() {

        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public User(String email, String name, String password, String phone_number, String api_token) {

        this.email = email;
        this.name = name;
        this.password = password;
        this.phone_number = phone_number;
        this.api_token = api_token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String email, String name, String password) {

        this.email = email;
        this.name = name;
        this.password = password;
    }
}
