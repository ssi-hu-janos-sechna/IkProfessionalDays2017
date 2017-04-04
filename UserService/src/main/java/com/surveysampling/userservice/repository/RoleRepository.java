package com.surveysampling.userservice.repository;

import com.surveysampling.userservice.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by janos_sechna on 3/31/17.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}