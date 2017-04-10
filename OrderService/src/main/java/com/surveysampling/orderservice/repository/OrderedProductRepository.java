package com.surveysampling.orderservice.repository;

import com.surveysampling.orderservice.model.OrderedProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by janos_sechna on 4/9/17.
 */
@Repository
public interface OrderedProductRepository extends CrudRepository<OrderedProducts, Long> {

}
