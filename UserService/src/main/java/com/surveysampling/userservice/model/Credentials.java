package com.surveysampling.userservice.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by janos_sechna on 3/31/17.
 */
public class Credentials {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    public Credentials() {
    }

    public Credentials(User user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
    }

    public Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}