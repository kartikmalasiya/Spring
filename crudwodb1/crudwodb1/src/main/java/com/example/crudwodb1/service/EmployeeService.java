package com.example.crudwodb1.service;

import com.example.crudwodb1.model.Employee;
import com.example.crudwodb1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployees(){
        return repository.getAllEmployee();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id);
    }

    public String deleteEmployee(int id) {
        repository.delete(id);
        return "Employee removed !! " + id;
    }

    public Employee updateEmployee(Employee employee) {
        return repository.update(employee);
    }
}
