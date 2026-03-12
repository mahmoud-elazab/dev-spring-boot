package com.melazab.springboot.cruddemo.dao;

import com.melazab.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
