package com.surveysampling.orderservice.service;

import com.surveysampling.orderservice.model.OrderEntry;

import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
public interface OrderService {

    List<OrderEntry> getOrders();

    OrderEntry saveOrder(OrderEntry orderEntry);

    OrderEntry getOrderById(Long orderId);

}