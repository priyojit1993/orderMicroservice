package com.priyojitpal.ordermicroservice.services;

import com.priyojitpal.ordermicroservice.entities.Order;
import com.priyojitpal.ordermicroservice.models.OrderRequest;
import com.priyojitpal.ordermicroservice.producer.OrderInventoryProducer;
import com.priyojitpal.ordermicroservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderInventoryProducer orderInventoryProducer;

    public OrderService(OrderRepository orderRepository, OrderInventoryProducer orderInventoryProducer) {
        this.orderRepository = orderRepository;
        this.orderInventoryProducer = orderInventoryProducer;
    }

    public Optional<Order> createNewOrder(OrderRequest orderRequest) {
        String id = UUID.randomUUID().toString();
        Order order = new Order(id, orderRequest.getOrderName(), orderRequest.getProductId(), orderRequest.getProductName(), orderRequest.getInventoryId());
        //send message to kafka topic
        orderInventoryProducer.inventoryUpdate(order);

        return Optional.of(orderRepository.save(order));
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }
}
