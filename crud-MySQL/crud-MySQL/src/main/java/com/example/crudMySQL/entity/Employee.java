package com.example.crudMySQL.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;
    @Column(nullable = false)
    private String emp_name;
    @Column(nullable = false)
    private String job_name;
    @Column(nullable = false)
    private int manager_id;
    @Column(nullable = false)
    private String hire_date;
    @Column(nullable = false)
    private double salary;
    @Column(nullable = false)
    private double commission;
    @Column(nullable = false)
    private int dept_id;
}
