package com.surveysampling.apigateway.feign;

import com.surveysampling.apigateway.feign.models.Category;
import com.surveysampling.apigateway.feign.models.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by janos_sechna on 4/3/17.
 */
@FeignClient("productservice")
public interface ProductFeignClient {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    List<Product> getProducts();

    @RequestMapping(value = "/products/categories", method = RequestMethod.GET)
    List<Category> getCategories();

    @RequestMapping(value = "/products/{productId}/exist", method = RequestMethod.GET)
    boolean isProductExist(@PathVariable("productId") Long id);

    @RequestMapping(value = "/products/exist", method = RequestMethod.GET)
    boolean isProductsExist(@RequestParam("productIds") List<Long> ids);

    @RequestMapping(value = "/products/category/{categoryId}", method = RequestMethod.GET)
    List<Product> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId);

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    Product addProduct(@RequestBody @Valid Product product);

    @RequestMapping(value = "/products/category", method = RequestMethod.POST)
    Category addCategory(@RequestBody @Valid Category category);

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    Product getProductById(@PathVariable("productId") Long id);
}