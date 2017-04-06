package com.surveysampling.apigateway.model;

import com.surveysampling.apigateway.feign.models.ActionType;

/**
 * Created by janos_sechna on 4/6/17.
 */
public class DepotTransaction {

    private String productName;

    private ActionType actionType;

    private int quantity;

    public DepotTransaction() {
    }

    public DepotTransaction(String productName, ActionType actionType, int quantity) {
        this.productName = productName;
        this.actionType = actionType;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
