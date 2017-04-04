package com.surveysampling.depotservice.repository;

import com.surveysampling.depotservice.model.Depot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Repository
public interface DepotRepository extends CrudRepository<Depot, Long> {

    @Override
    List<Depot> findAll();

    @Modifying
    @Query(value = "UPDATE depot d SET d.current_stored_unit = d.current_stored_unit + :value WHERE d.id= :depotId", nativeQuery = true)
    int updateDepotStorage(@Param("depotId") Long depotId, @Param("value") int value);

}