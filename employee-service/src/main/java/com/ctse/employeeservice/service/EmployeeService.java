package com.ctse.employeeservice.service;

import com.ctse.employeeservice.dto.EmployeeUpdateDTO;
import com.ctse.employeeservice.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    String deleteEmployeeById(Integer id);

    Employee updateEmployee(Integer id,  EmployeeUpdateDTO employeeUpdateDTO);

    Employee employeeLogin(String email, String password);
}
