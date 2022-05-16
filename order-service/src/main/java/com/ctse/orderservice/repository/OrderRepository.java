package com.ctse.orderservice.repository;

import com.ctse.orderservice.entity.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Integer> {
}
