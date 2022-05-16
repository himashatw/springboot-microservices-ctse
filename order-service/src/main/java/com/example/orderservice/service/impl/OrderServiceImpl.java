package com.example.orderservice.service.impl;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public boolean deleteById(int id) {
        Order order = new Order();
        int orderId = order.getId();
        if (orderId == id){
            orderRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }

    }
}
