package com.surveysampling.apigateway.model;

import com.surveysampling.apigateway.feign.models.Depot;

/**
 * Created by janos_sechna on 4/9/17.
 */
public class ProductStock {

    private Depot depot;

    private Long quantity;

    public ProductStock(Depot depot, Long quantity) {
        this.depot = depot;
        this.quantity = quantity;
    }

    public ProductStock() {
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
