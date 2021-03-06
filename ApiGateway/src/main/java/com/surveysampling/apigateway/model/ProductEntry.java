package com.surveysampling.apigateway.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by janos_sechna on 4/5/17.
 */
public class ProductEntry {

    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    private Long quantity;

    public ProductEntry() {
    }

    public ProductEntry(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
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
