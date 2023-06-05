package com.example.crudwodb1.repository;

import com.example.crudwodb1.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private List<Employee> list= new ArrayList<Employee>();

    public void createEmployee(){
        list = List.of(
                new Employee(64989,"ADELYN","SALESMAN",669281,"991-02-20",1700.00,400.00,001)
        );

    }

    public List<Employee> getAllEmployee(){
        return list;
    }

    public Employee findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmp_id() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Employee> search(String name) {
        return list.stream().filter(x -> x.getEmp_name().startsWith(name)).collect(Collectors.toList());
    }

    public Employee save(Employee p) {
        Employee employee = new Employee();
        employee.setEmp_id(p.getEmp_id());
        employee.setEmp_name(p.getEmp_name());
        employee.setJob_name(p.getJob_name());
        employee.setManager_id(p.getManager_id());
        employee.setHire_date(p.getHire_date());
        employee.setSalary(p.getSalary());
        employee.setCommission(p.getCommission());
        employee.setDept_id(p.getDept_id());
        list.add(employee);
        return employee;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getEmp_id() == (id));
        return null;
    }

    public Employee update(Employee employee) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmp_id() == (employee.getEmp_id())) {
                id = employee.getEmp_id();
                idx = i;
                break;
            }
        }

        Employee employee1 = new Employee();
        employee1.setEmp_id(id);
        employee1.setEmp_name(employee.getEmp_name());
        employee1.setJob_name(employee.getJob_name());
        employee1.setManager_id(employee.getManager_id());
        employee1.setHire_date(employee.getHire_date());
        employee1.setSalary(employee.getSalary());
        employee1.setCommission(employee.getCommission());
        employee1.setDept_id(employee.getDept_id());
        list.set(idx, employee);
        return employee1;
    }

}
