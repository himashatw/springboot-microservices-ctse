package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

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
