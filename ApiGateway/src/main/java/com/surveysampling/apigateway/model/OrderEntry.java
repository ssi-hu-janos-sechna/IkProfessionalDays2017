package com.surveysampling.apigateway.model;

import java.util.Date;
import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
public class OrderEntry {

    private Long id;

    private Date orderDate;

    private List<OrderedProducts> products;

    private OrderStatus status;

    private Long userId;

    public OrderEntry(Long id, Date orderDate, List<OrderedProducts> products, OrderStatus status, Long userId) {
        this.id = id;
        this.orderDate = orderDate;
        this.products = products;
        this.status = status;
        this.userId = userId;
    }

    public OrderEntry(List<OrderedProducts> products, Long userId) {
        this.products = products;
        this.userId = userId;
    }

    public OrderEntry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderedProducts> getProducts() {
        return products;
    }

    public void setProducts(List<OrderedProducts> products) {
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}