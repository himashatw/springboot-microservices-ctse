package com.ctse.orderservice.service;

import com.ctse.orderservice.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

public interface OrderService {

    public List<Order> getAll();

    public Order addOrder(Order order);

    public boolean deleteById(int id);
}
