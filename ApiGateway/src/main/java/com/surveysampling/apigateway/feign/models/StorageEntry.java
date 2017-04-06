package com.surveysampling.apigateway.feign.models;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by janos_sechna on 4/3/17.
 */
public class StorageEntry {

    private Long id;

    private ActionType actionType;

    private Date date;

    private Long productId;

    private Long depotId;

    private Long userId;

    @Min(0)
    private int quantity;


    public StorageEntry(ActionType actionType, Date date, Long productId, Long depotId, Long userId, int quantity) {
        this.actionType = actionType;
        this.date = date;
        this.productId = productId;
        this.depotId = depotId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public StorageEntry(ActionType actionType, Long productId, Long depotId, Long userId, int quantity) {
        this.actionType = actionType;
        this.productId = productId;
        this.depotId = depotId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public StorageEntry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}