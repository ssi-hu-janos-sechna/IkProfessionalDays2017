package com.surveysampling.storageservice.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by janos_sechna on 4/3/17.
 */
@Entity
@Table(name = "storage")
public class StorageEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @Column(name = "START_DATE", columnDefinition = "DATE DEFAULT CURRENT_DATE", updatable = false)
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