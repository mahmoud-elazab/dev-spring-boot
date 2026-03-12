package com.melazab.springboot.cruddemo.rest;

import com.melazab.springboot.cruddemo.dao.EmployeeDAO;
import com.melazab.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    // quick and dirty: inject employee dao (using constructor injection)

    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }


    // expose "/employess" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
