package com.surveysampling.orderservice;

import com.surveysampling.orderservice.model.OrderEntry;
import com.surveysampling.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by janos_sechna on 4/9/17.
 */
@RestController
@RequestMapping("orders")
public class OrderController {


    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public OrderEntry getOrderById(@PathVariable("orderId") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping
    public List<OrderEntry> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public OrderEntry saveOrder(@RequestBody OrderEntry orderEntry) {
        return orderService.saveOrder(orderEntry);
    }
}