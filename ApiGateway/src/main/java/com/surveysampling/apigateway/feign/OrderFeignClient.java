package com.surveysampling.apigateway.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("orderservice")
public interface OrderFeignClient {
}
