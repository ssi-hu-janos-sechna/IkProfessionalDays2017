package com.surveysampling.apigateway;

import com.surveysampling.apigateway.feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by janos_sechna on 4/3/17.
 */
@RestController
public class GatewayController {

    private DepotFeignClient depotFeignClient;

    private OrderFeignClient orderFeignClient;

    private ProductFeignClient productFeignClient;

    private StorageFeignClient storageFeignClient;

    private UserFeignClient userFeignClient;

    @Autowired
    public GatewayController(DepotFeignClient depotFeignClient, OrderFeignClient orderFeignClient, ProductFeignClient productFeignClient, StorageFeignClient storageFeignClient, UserFeignClient userFeignClient) {
        this.depotFeignClient = depotFeignClient;
        this.orderFeignClient = orderFeignClient;
        this.productFeignClient = productFeignClient;
        this.storageFeignClient = storageFeignClient;
        this.userFeignClient = userFeignClient;
    }


    @GetMapping
    String a() {
        return "a";
    }


}