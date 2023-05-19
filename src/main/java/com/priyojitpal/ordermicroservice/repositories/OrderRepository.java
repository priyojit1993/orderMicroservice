package com.priyojitpal.ordermicroservice.repositories;

import com.priyojitpal.ordermicroservice.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,String> {
}
