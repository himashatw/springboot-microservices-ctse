package com.ctse.customerservice.service.impl;

import com.ctse.customerservice.entity.Customer;
import com.ctse.customerservice.resource.CustomerUpdateResource;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> getAll();

    public Customer addCustomer(Customer customer);

    public String deleteById(int id);

    public Customer updateCustomer(int id,  CustomerUpdateResource customerUpdateResource);

    public Customer loginCustomer(String email, String password);
}
