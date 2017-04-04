package com.surveysampling.productservice.repository;

import com.surveysampling.productservice.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    List<Product> findAll();

    List<Product> findProductsByCategory_IdOrderByName(Long id);

}
