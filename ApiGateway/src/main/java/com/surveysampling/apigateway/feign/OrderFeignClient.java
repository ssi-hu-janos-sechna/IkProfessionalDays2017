package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.model.OrderEntry;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("orderservice")
public interface OrderFeignClient {


    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    OrderEntry getOrderById(@PathVariable("orderId") Long orderId);

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    List<OrderEntry> getOrders();

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    OrderEntry saveOrder(@RequestBody OrderEntry orderEntry);
}
