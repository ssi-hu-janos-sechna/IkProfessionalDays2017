package com.surveysampling.userservice.service;

import com.surveysampling.userservice.model.Credentials;
import com.surveysampling.userservice.model.User;
import com.surveysampling.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


/**
 * Created by janos_sechna on 3/31/17.
 */
@Service
public class AuthenticationService {

    private UserRepository userRepository;

    private JwtService jwtService;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String login(Credentials credentials) {
        User userDetail = userRepository.findByUsername(credentials.getUserName());
        if ((passwordEncoder.matches(credentials.getPassword(), userDetail.getPassword()))) {
            return jwtService.tokenFor(userDetail);
        } else {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Username or password invalid.");
        }

    }

}
