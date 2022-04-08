package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.Employee;

public interface EmployeeService {
	 List<Employee> getAllEmployees();
	 void saveEmployee(Employee employee);
	 Employee getEmployeeById(long id);
}