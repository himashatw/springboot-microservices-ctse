package com.ctse.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.ctse.orderservice.entity.Order;
import com.ctse.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    
    @GetMapping()
    public String hello() {
        return "Hello from Order Service";
    }

    @GetMapping(value = "/placeOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        try {
            Order newOrder = orderService.addOrder(order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "all")
    public ResponseEntity<Object> getAllOrders(){
        try {
            List<Order> orders = orderService.getAll();
            if (!orders.isEmpty()){
                return new ResponseEntity<>(orders,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/delete/{id}")
    public boolean deleteOrder(@PathVariable(value = "id", required = true) int id){
        return orderService.deleteById(id);
    }

}
