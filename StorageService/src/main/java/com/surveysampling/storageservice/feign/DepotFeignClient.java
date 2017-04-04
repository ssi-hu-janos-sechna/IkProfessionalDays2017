package com.surveysampling.storageservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("DEPOTSERVICE")
@RequestMapping("depots")
public interface DepotFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    void updateDepotStorageStatus(@PathVariable("id") @Min(1) Long depotId,
                                  @RequestParam("value") int value);
}