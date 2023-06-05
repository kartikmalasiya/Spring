package com.example.crudMySQL.repository;


import com.example.crudMySQL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
