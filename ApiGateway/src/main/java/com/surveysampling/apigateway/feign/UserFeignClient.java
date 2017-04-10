package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.feign.models.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.Min;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("userservice")
public interface UserFeignClient {

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User getUserById(@PathVariable("id") @Min(1) Long id);
}
