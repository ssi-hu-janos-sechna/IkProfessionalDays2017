package com.surveysampling.userservice.service;

import com.surveysampling.userservice.model.User;

/**
 * Created by janos_sechna on 3/31/17.
 */
public interface UserService {

    User getUserById(long id);

    User loadUserByUsername(String userName);

    User saveUser(User user);

}