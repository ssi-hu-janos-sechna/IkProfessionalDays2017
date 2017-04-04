package com.surveysampling.productservice.service;

import com.surveysampling.productservice.model.Category;
import com.surveysampling.productservice.model.Product;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
public interface ProductService {

    List<Product> getProducts();

    List<Category> getCategories();

    List<Product> getProductsByCategoryId(Long categoryId);

    Product addProduct(Product product);

    Category addCategory(Category category);

    boolean isProductExist(Long id);
}
