package com.ctse.customerservice.controller;

import com.ctse.customerservice.entity.Customer;
import com.ctse.customerservice.resource.CustomerUpdateResource;
import com.ctse.customerservice.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public String hello() {
        return "Hello from Customer Service";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        try {
            Customer customerAdded = customerService.addCustomer(customer);
            return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllItems() {
        try {
            List<Customer> items = customerService.getAll();
            if (!items.isEmpty()) {
                return new ResponseEntity<>(items, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable(value = "id", required = true) int id) {
        String message= customerService.deleteById(id);
        return message;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id", required = true) int id,
                                           @RequestBody CustomerUpdateResource itemUpdateResource) {
        try {
            Customer itemUpdated = customerService.updateCustomer(id, itemUpdateResource);
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value ="/login")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        try {
            Customer getCustomer = customerService.loginCustomer(customer.getEmail(),customer.getPassword());
            return new ResponseEntity<>(getCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
