package com.surveysampling.apigateway.model;

/**
 * Created by janos_sechna on 4/9/17.
 */
public class OrderedProducts {

    private Long id;

    private Long productId;

    private Long quantity;

    public OrderedProducts(ProductEntry productEntry) {
        this.productId = productEntry.getProductId();
        this.quantity = productEntry.getQuantity();
    }

    public OrderedProducts(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderedProducts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}