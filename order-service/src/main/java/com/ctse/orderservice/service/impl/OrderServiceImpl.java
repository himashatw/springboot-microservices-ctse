package com.ctse.orderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.ctse.orderservice.entity.Order;
import com.ctse.orderservice.repository.OrderRepository;
import com.ctse.orderservice.service.OrderService;
import org.springframework.stereotype.Component;

@Component
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
