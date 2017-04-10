package com.surveysampling.orderservice.repository;

import com.surveysampling.orderservice.model.OrderEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
@Repository
public interface OrderRepository extends CrudRepository<OrderEntry, Long> {

    @Override
    List<OrderEntry> findAll();
}
