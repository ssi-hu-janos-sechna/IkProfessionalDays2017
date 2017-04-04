package com.surveysampling.productservice.repository;

import com.surveysampling.productservice.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    List<Category> findAll();

}
