package com.surveysampling.apigateway.feign.models;

import java.util.List;

/**
 * Created by janos_sechna on 3/31/17.
 */
public class LoginResponse {

    private String userName;
    private String token;
    private List<Role> roles;

    public LoginResponse() {
    }

    public LoginResponse(String userName, String token, List<Role> roles) {
        this.userName = userName;
        this.token = token;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}