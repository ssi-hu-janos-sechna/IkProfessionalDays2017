package com.surveysampling.productservice;

import com.surveysampling.productservice.model.Category;
import com.surveysampling.productservice.model.Product;
import com.surveysampling.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("categories")
    List<Category> getCategories() {
        return productService.getCategories();
    }

    @GetMapping("/{productId}/exist")
    boolean isProductExist(@PathVariable("productId") Long id) {
        return productService.isProductExist(id);
    }

    @GetMapping("category/{categoryId}")
    List<Product> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    @PostMapping
    Product addProduct(@RequestBody @Valid Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("category")
    Category addCategory(@RequestBody @Valid Category category) {
        return productService.addCategory(category);
    }

}
