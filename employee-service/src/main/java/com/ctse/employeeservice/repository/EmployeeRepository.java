package com.ctse.employeeservice.repository;

import com.ctse.employeeservice.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

     Employee findByEmailAndPassword(String email,String password);
}
