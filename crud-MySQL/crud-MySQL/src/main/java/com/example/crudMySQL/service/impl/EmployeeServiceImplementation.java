package com.example.crudMySQL.service.impl;

import lombok.AllArgsConstructor;
import com.example.crudMySQL.entity.Employee;
import com.example.crudMySQL.repository.EmployeeRepository;
import com.example.crudMySQL.service.EmployeeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getEmp_id()).get();
        existingEmployee.setCommission(employee.getCommission());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDept_id(employee.getDept_id());
        existingEmployee.setHire_date(employee.getHire_date());
        existingEmployee.setJob_name(employee.getJob_name());
        existingEmployee.setEmp_name(employee.getEmp_name());
        existingEmployee.setManager_id(employee.getManager_id());
        Employee updatedUser = employeeRepository.save(existingEmployee);
        return updatedUser;
    }

    @Override
    public void deleteEmployee(int userId) {
        employeeRepository.deleteById(userId);
    }
}
