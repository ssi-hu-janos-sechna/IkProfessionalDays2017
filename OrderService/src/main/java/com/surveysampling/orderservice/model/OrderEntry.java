package com.surveysampling.orderservice.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Entity
@Table(name = "orders")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date orderDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<OrderedProducts> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Long userId;

    @PrePersist
    protected void onCreate() {
        orderDate = new Date();
    }

    public OrderEntry(Date orderDate, List<OrderedProducts> products, OrderStatus status, Long userId) {
        this.orderDate = orderDate;
        this.products = products;
        this.status = status;
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