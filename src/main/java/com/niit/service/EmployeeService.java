package com.niit.service;

import java.util.List;

import com.niit.model.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empID);
	public List<Employee> listEmployee();
	public Employee getEmployee(int empID);
	public Employee getById(int empID);
}
