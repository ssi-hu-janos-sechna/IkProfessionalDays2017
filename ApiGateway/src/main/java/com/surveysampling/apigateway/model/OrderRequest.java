package com.surveysampling.apigateway.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
public class OrderRequest {

    @NotNull
    @Min(0)
    Long userId;

    @NotEmpty
    List<ProductEntry> products;

    public OrderRequest(Long userId, List<ProductEntry> products) {
        this.userId = userId;
        this.products = products;
    }

    public OrderRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductEntry> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntry> products) {
        this.products = products;
    }
}