package com.surveysampling.storageservice.repository;

import com.surveysampling.storageservice.model.StorageEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@Repository
public interface StorageRepository extends CrudRepository<StorageEntry, Long> {

    @Override
    List<StorageEntry> findAll();

    List<StorageEntry> findAllByDepotId(Long id);

    List<StorageEntry> findAllByProductId(Long id);

}