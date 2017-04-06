package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.feign.models.Depot;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("depotservice")
public interface DepotFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    List<Depot> getDepots();

    @Cacheable("depot")
    @RequestMapping(value = "/depots/{depotId}", method = RequestMethod.GET)
    Depot getDepotById(@PathVariable("depotId") @Min(1) Long depotId);

    @RequestMapping(value = "/depots", method = RequestMethod.POST)
    Depot addDepot(@RequestBody @Valid Depot depot);

}
