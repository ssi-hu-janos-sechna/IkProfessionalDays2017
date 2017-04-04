package com.surveysampling.userservice;

import com.surveysampling.userservice.model.Credentials;
import com.surveysampling.userservice.model.RegisterResponse;
import com.surveysampling.userservice.model.User;
import com.surveysampling.userservice.service.AuthenticationService;
import com.surveysampling.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Created by janos_sechna on 3/31/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid Credentials credentials) {
        return authenticationService.login(credentials);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody @Valid Credentials credentials) {

        User user = new User();
        user.setUsername(credentials.getUserName());
        user.setPassword(credentials.getPassword());
        user = userService.saveUser(user);

        return new RegisterResponse(user, authenticationService.login(credentials));
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") @Min(1) int id) {
        return userService.getUserById(id);
    }
}