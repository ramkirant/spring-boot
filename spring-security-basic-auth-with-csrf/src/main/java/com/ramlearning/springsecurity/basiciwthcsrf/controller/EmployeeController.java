package com.ramlearning.springsecurity.basiciwthcsrf.controller;

import com.ramlearning.springsecurity.basiciwthcsrf.entity.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private List<Employee> employeeList;

    public EmployeeController() {
        employeeList = new ArrayList<>();
        Collections.addAll(employeeList,
                new Employee(1, "Ram"),
                new Employee(2, "Kiran"));
    }

    @GetMapping()
    public List<Employee> getEmployees(){
        return employeeList;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping()
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }
}
