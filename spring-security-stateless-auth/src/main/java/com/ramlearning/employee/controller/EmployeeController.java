package com.ramlearning.employee.controller;

import com.ramlearning.employee.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    List<Employee> employeeList;

    public EmployeeController() {
        employeeList= new ArrayList<>();
        Collections.addAll(employeeList,
                new Employee(1, "Ram"),
                new Employee(2, "Kiran"));
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeList;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employee;
    }
}
