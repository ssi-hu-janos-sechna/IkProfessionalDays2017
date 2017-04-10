package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.feign.models.StorageEntry;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("storageservice")
public interface StorageFeignClient {

    @RequestMapping(value = "/storage/{id}", method = RequestMethod.GET)
    StorageEntry getStorageEntry(@PathVariable("id") Long entryId);

    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    List<StorageEntry> getAllStorageEntry();

    @RequestMapping(value = "/storage/depot/{id}", method = RequestMethod.GET)
    List<StorageEntry> getAllStorageEntryForDepotById(@PathVariable("id") Long depotId);

    @RequestMapping(value = "/storage/product/{id}", method = RequestMethod.GET)
    List<StorageEntry> getAllStorageEntryForProductById(@PathVariable("id") Long productId);

    @RequestMapping(value = "/storage/list", method = RequestMethod.POST)
    void addStorageEntries(@RequestBody List<StorageEntry> storageEntries);

    @RequestMapping(value = "/storage", method = RequestMethod.POST)
    StorageEntry addStorageEntry(@RequestBody StorageEntry storageEntry);
}
