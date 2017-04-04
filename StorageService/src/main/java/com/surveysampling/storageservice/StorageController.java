package com.surveysampling.storageservice;

import com.surveysampling.storageservice.model.StorageEntry;
import com.surveysampling.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@RestController
@RequestMapping("/storage")
public class StorageController {


    StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/{id}")
    StorageEntry getStorageEntry(@PathVariable("id") Long entryId) {
        return storageService.getStorageEntry(entryId);
    }

    @GetMapping
    List<StorageEntry> getAllStorageEntry() {
        return storageService.getAllStorageEntry();
    }

    @GetMapping("/depot/{id}")
    List<StorageEntry> getAllStorageEntryForDepotById(@PathVariable("id") Long depotId) {
        return storageService.getAllStorageEntryForDepotById(depotId);
    }

    @PutMapping("/list")
    void addStorageEntries(@RequestBody List<StorageEntry> storageEntries) {
        storageService.addStorageEntries(storageEntries);
    }

    @PutMapping
    StorageEntry addStorageEntry(@RequestBody StorageEntry storageEntry) {
        return storageService.addStorageEntry(storageEntry);
    }


}
