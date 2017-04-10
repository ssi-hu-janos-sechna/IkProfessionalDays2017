package com.surveysampling.orderservice.model;

import javax.persistence.*;

/**
 * Created by janos_sechna on 4/9/17.
 */
@Entity
@Table(name = "products")
public class OrderedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Long quantity;

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