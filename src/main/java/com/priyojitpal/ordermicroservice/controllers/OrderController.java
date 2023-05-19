package com.priyojitpal.ordermicroservice.controllers;

import com.priyojitpal.ordermicroservice.entities.Order;
import com.priyojitpal.ordermicroservice.models.OrderRequest;
import com.priyojitpal.ordermicroservice.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        Optional<Order> newOrder = orderService.createNewOrder(orderRequest);
        if (newOrder.isPresent())
            return ResponseEntity.ok(newOrder.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
