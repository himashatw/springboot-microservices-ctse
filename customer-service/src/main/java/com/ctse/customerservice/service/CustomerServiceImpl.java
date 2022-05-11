package com.ctse.customerservice.service;

import com.ctse.customerservice.entity.Customer;
import com.ctse.customerservice.repository.CustomerRepository;
import com.ctse.customerservice.resource.CustomerUpdateResource;
import com.ctse.customerservice.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public String deleteById(int id) {
        Customer customer = new Customer();
        int customerId = customer.getId();
        if(customerId != id) {
            customerRepository.deleteById(id);
            return "Customer Id "+ id +" Deleted Successfully";
        }else {
            return "Customer id is Invalid";
        }
    }

    @Override
    public Customer updateCustomer(int id, CustomerUpdateResource customerUpdateResource) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();// optional covert to an object
            if (customer.getName() != null && (!customer.getName().isEmpty())) {
                customer.setName(customer.getName());
            }
            if (customerUpdateResource.getName() != null && (!customerUpdateResource.getName().isEmpty())) {
                customer.setName(customerUpdateResource.getName());
            }
            if (customerUpdateResource.getEmail() != null && (!customerUpdateResource.getEmail().isEmpty())) {
                customer.setEmail(customerUpdateResource.getEmail());
            }
            if (customerUpdateResource.getMobile() != null) {
                customer.setMobile(customerUpdateResource.getMobile());
            }
            if (customerUpdateResource.getPassword() != null&&(!customerUpdateResource.getEmail().isEmpty())) {
                customer.setPassword(customerUpdateResource.getPassword());
            }
            customerRepository.save(customer);
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public Customer loginCustomer(String email, String password) {
        System.out.println(email);
        System.out.println(password);
        return customerRepository.findByEmailAndPassword(email,password);
    }
}
