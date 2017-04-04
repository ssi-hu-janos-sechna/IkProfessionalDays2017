package com.surveysampling.orderservice.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Entity
@Table(name = "orders")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long productId;

    Date orderDate;

    @Enumerated(EnumType.STRING)
    OrderStatus status;
}