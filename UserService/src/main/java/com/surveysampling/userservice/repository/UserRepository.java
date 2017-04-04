package com.surveysampling.userservice.repository;

import com.surveysampling.userservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by janos_sechna on 3/31/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findById(Long id);

}
