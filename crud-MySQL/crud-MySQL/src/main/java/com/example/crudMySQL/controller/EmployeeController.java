package com.example.crudMySQL.controller;

import com.example.crudMySQL.entity.Employee;
import com.example.crudMySQL.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees-mysql")
public class EmployeeController {


    private EmployeeService employeeService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/employees-mysql/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/employees-mysql
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/employees-mysql/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int employeeId,
                                           @RequestBody Employee employee){
        employee.setEmp_id(employeeId);
        Employee updatedUser = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
