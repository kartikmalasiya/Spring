package com.example.crudwodb1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int emp_id;
    private String emp_name;
    private String job_name;
    private int manager_id;
    private String hire_date;
    private double salary;
    private double commission;
    private int dept_id;
}
