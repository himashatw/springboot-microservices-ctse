package com.ctse.customerservice.repository;

import com.ctse.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    public Customer findByEmailAndPassword(String email,String password);

}
