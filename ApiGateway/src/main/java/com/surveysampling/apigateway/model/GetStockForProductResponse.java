package com.surveysampling.apigateway.model;

import com.surveysampling.apigateway.feign.models.Product;

import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
public class GetStockForProductResponse {

    private Product product;

    private List<ProductStock> productList;

    public GetStockForProductResponse(Product product, List<ProductStock> productList) {
        this.product = product;
        this.productList = productList;
    }

    public GetStockForProductResponse() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductStock> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductStock> productList) {
        this.productList = productList;
    }
}
