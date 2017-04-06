package com.surveysampling.apigateway.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by janos_sechna on 4/5/17.
 */
public class StoreProductsRequest {

    @NotNull
    @Min(0)
    private Long depotId;

    @NotEmpty
    @Valid
    private List<ProductEntry> product;

    @NotNull
    private Long userId;


    public StoreProductsRequest() {
    }

    public StoreProductsRequest(Long depotId, List<ProductEntry> product, Long userId) {
        this.depotId = depotId;
        this.product = product;
        this.userId = userId;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public List<ProductEntry> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntry> product) {
        this.product = product;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}