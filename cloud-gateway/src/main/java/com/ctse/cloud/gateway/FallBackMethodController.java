package com.ctse.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBackMethod() {
        return "Product Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/employeeServiceFallBack")
    public String employeeServiceFallBackMethod() {
        return "Employee Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/customerServiceFallBack")
    public String customerServiceFallBackMethod() {
        return "Customer Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallBackMethod() {
        return "Order Service is taking longer than Expected." +
                " Please try again later";
    }
}
