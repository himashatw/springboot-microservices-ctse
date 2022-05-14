package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {

    public List<Order> getAll();

    public Order addOrder(Order order);

    public boolean deleteById(int id);
}
