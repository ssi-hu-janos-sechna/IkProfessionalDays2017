package com.surveysampling.productservice.service;

import com.surveysampling.productservice.model.Category;
import com.surveysampling.productservice.model.Product;
import com.surveysampling.productservice.repository.CategoryRepository;
import com.surveysampling.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findProductsByCategory_IdOrderByName(categoryId);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isProductExist(Long id) {
        return productRepository.exists(id);
    }

    @Override
    public boolean isProductsExist(List<Long> ids) {
        return ids.parallelStream().allMatch(productRepository::exists);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findOne(id);
    }
}
