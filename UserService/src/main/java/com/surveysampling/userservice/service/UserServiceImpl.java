package com.surveysampling.userservice.service;

import com.surveysampling.userservice.model.User;
import com.surveysampling.userservice.repository.RoleRepository;
import com.surveysampling.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;


/**
 * Created by janos_sechna on 3/31/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setRole(roleRepository.findOne(2L));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Username or password invalid.");
        }

        return user;

    }
}
