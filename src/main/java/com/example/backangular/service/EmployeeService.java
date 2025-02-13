package com.example.backangular.service;



import com.example.backangular.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee findEmployeeById(int id);
    List<Employee> findAllEmployees();
    void deleteEmployeeById(int id);
    Employee updateEmployee(Employee employee);
}
