package com.example.crudMySQL.service;

import com.example.crudMySQL.entity.Employee;
import java.util.List;
public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(int userId);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee);

    void deleteEmployee(int userId);
}
