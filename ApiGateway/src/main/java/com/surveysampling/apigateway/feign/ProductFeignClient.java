package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.feign.models.Category;
import com.surveysampling.apigateway.feign.models.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("productservice")
@RequestMapping("/products")
public interface ProductFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    List<Product> getProducts();

    @RequestMapping(value = "categories", method = RequestMethod.GET)
    List<Category> getCategories();

    @RequestMapping(value = "/{productId}/exist", method = RequestMethod.GET)
    boolean isProductExist(@PathVariable("productId") Long id);

    @RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
    List<Product> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId);

    @RequestMapping(method = RequestMethod.POST)
    Product addProduct(@RequestBody @Valid Product product);

    @RequestMapping(value = "category", method = RequestMethod.POST)
    Category addCategory(@RequestBody @Valid Category category);

}