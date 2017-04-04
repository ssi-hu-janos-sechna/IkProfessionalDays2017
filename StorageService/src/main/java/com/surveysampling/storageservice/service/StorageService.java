package com.surveysampling.storageservice.service;

import com.surveysampling.storageservice.model.StorageEntry;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
public interface StorageService {

    StorageEntry addStorageEntry(StorageEntry storageEntry);

    void addStorageEntries(List<StorageEntry> storageEntries);

    StorageEntry getStorageEntry(Long entryId);

    List<StorageEntry> getAllStorageEntry();

    List<StorageEntry> getAllStorageEntryForDepotById(Long depotId);

}