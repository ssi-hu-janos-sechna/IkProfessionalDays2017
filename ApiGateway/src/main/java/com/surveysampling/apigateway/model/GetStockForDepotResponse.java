package com.surveysampling.apigateway.model;

import com.surveysampling.apigateway.feign.models.Depot;

import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
public class GetStockForDepotResponse {

    private Depot depot;

    private List<ProductEntry> productList;

    public GetStockForDepotResponse(Depot depot, List<ProductEntry> productList) {
        this.depot = depot;
        this.productList = productList;
    }

    public GetStockForDepotResponse() {
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public List<ProductEntry> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntry> productList) {
        this.productList = productList;
    }
}
