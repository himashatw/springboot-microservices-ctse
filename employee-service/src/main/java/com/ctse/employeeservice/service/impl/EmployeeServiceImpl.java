package com.ctse.employeeservice.service.impl;

import com.ctse.employeeservice.dto.EmployeeUpdateDTO;
import com.ctse.employeeservice.entity.Employee;
import com.ctse.employeeservice.repository.EmployeeRepository;
import com.ctse.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        Employee employee = new Employee();
        Integer employeeId = employee.getId();
        if(employeeId != id) {
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully";
        }else {
            return "Employee id is Invalid";
        }
    }

    @Override
    public Employee updateEmployee(Integer id, EmployeeUpdateDTO employeeUpdateDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            if (employee.getName() != null && (!employee.getName().isEmpty())) {
                employee.setName(employee.getName());
            }
            if (employeeUpdateDTO.getName() != null && (!employeeUpdateDTO.getName().isEmpty())) {
                employee.setName(employeeUpdateDTO.getName());
            }
            if (employeeUpdateDTO.getPosition() != null && (!employeeUpdateDTO.getPosition().isEmpty())) {
                employee.setPosition(employeeUpdateDTO.getPosition());
            }
            if (employeeUpdateDTO.getEmail() != null && (!employeeUpdateDTO.getEmail().isEmpty())) {
                employee.setEmail(employeeUpdateDTO.getEmail());
            }
            if (employeeUpdateDTO.getMobile() != null) {
                employee.setMobile(employeeUpdateDTO.getMobile());
            }
            if (employeeUpdateDTO.getPassword() != null&&(!employeeUpdateDTO.getEmail().isEmpty())) {
                employee.setPassword(employeeUpdateDTO.getPassword());
            }
            employeeRepository.save(employee);
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee employeeLogin(String email, String password) {
        return employeeRepository.findByEmailAndPassword(email,password);
    }
}
