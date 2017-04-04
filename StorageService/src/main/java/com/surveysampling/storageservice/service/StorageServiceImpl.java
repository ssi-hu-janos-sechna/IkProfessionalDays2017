package com.surveysampling.storageservice.service;

import com.surveysampling.storageservice.feign.DepotFeignClient;
import com.surveysampling.storageservice.model.ActionType;
import com.surveysampling.storageservice.model.StorageEntry;
import com.surveysampling.storageservice.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@Service
public class StorageServiceImpl implements StorageService {

    private StorageRepository storageRepository;

    private DepotFeignClient depotFeignClient;

    @Autowired
    public StorageServiceImpl(StorageRepository storageRepository, DepotFeignClient depotFeignClient) {
        this.storageRepository = storageRepository;
        this.depotFeignClient = depotFeignClient;
    }

    @Override
    @Transactional
    public StorageEntry addStorageEntry(StorageEntry storageEntry) {
        StorageEntry entry = storageRepository.save(storageEntry);
        int quantity = storageEntry.getActionType() == ActionType.WITHDRAW ? (-storageEntry.getQuantity()) : storageEntry.getQuantity();
        depotFeignClient.updateDepotStorageStatus(storageEntry.getDepotId(), quantity);
        return entry;
    }

    @Override
    @Transactional
    public void addStorageEntries(List<StorageEntry> storageEntries) {
        storageRepository.save(storageEntries);
        storageEntries.parallelStream()
                .forEach(storageEntry -> {
                    int quantity = storageEntry.getActionType() == ActionType.WITHDRAW ? (-storageEntry.getQuantity()) : storageEntry.getQuantity();
                    depotFeignClient.updateDepotStorageStatus(storageEntry.getDepotId(), quantity);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public StorageEntry getStorageEntry(Long entryId) {
        return storageRepository.findOne(entryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StorageEntry> getAllStorageEntry() {
        return storageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<StorageEntry> getAllStorageEntryForDepotById(Long id) {
        return storageRepository.findAllByDepotId(id);
    }
}
