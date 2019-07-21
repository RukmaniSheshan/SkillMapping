package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.EmployeeDAO;
import com.niit.model.Employee;

@Service
@Repository("employeeService")
@Transactional
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public boolean addEmployee(Employee employee) {
		if(employeeDAO.getEmployee(employee.getEmpID())!=null) {
			return false;
		}
		else {
			employeeDAO.addEmployee(employee);
			return true;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(int empID) {
		if(employeeDAO.getEmployee(empID)!=null) {
			employeeDAO.deleteEmployee(empID);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.listEmployee();
	}

	@Override
	public Employee getEmployee(int empID) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(empID);
	}

	@Override
	public Employee getById(int empID) {
		return employeeDAO.getById(empID);
	}
}
