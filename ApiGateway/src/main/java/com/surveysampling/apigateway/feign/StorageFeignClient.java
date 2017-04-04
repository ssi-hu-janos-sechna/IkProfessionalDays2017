package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.feign.models.StorageEntry;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("storageservice")
@RequestMapping("storage")
public interface StorageFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    StorageEntry getStorageEntry(@PathVariable("id") Long entryId);

    @RequestMapping(method = RequestMethod.GET)
    List<StorageEntry> getAllStorageEntry();

    @RequestMapping(value = "/depot/{id}",method = RequestMethod.GET)
    List<StorageEntry> getAllStorageEntryForDepotById(@PathVariable("id") Long depotId);

    @RequestMapping(value = "/list",method = RequestMethod.PUT)
    void addStorageEntries(@RequestBody List<StorageEntry> storageEntries);

    @RequestMapping(method = RequestMethod.PUT)
    StorageEntry addStorageEntry(@RequestBody StorageEntry storageEntry);
}
