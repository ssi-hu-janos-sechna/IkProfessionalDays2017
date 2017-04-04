package com.surveysampling.apigateway.feign.models;

/**
 * Created by janos_sechna on 3/31/17.
 */
public class RegisterResponse {

    private User user;
    private String token;

    public RegisterResponse() {
    }

    public RegisterResponse(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}