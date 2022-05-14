package com.ctse.employeeservice.controller;

import com.ctse.employeeservice.dto.EmployeeUpdateDTO;
import com.ctse.employeeservice.entity.Employee;
import com.ctse.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

     @GetMapping()
    public String hello() {
        return "Hello from Employee Service";
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllItems() {
        try {
            List<Employee> items = employeeService.getAllEmployees();
            if (!items.isEmpty()) {
                return new ResponseEntity<>(items, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            Employee newEmployee = employeeService.addEmployee(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value ="/login")
    public ResponseEntity<Employee> updateCustomer(@RequestBody Employee employee) {
        try {
            Employee findEmployee = employeeService.employeeLogin(employee.getEmail(),employee.getPassword());
            return new ResponseEntity<>(findEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateCustomer(@PathVariable(value = "id", required = true) int id,
                                                   @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeUpdateDTO);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable(value = "id", required = true) int id) {
        String message= employeeService.deleteEmployeeById(id);
        return message;
    }
}
