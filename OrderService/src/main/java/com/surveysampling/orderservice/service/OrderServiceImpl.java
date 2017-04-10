package com.surveysampling.orderservice.service;

import com.surveysampling.orderservice.model.OrderEntry;
import com.surveysampling.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderEntry> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public OrderEntry saveOrder(OrderEntry orderEntry) {
        return orderRepository.save(orderEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderEntry getOrderById(Long orderId) {
        return orderRepository.findOne(orderId);
    }
}
