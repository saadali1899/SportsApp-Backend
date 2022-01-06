package com.example.sportsappbackend.service;


import com.example.sportsappbackend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
