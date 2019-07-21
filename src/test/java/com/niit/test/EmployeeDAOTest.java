package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.EmployeeDAO;
import com.niit.model.Employee;

public class EmployeeDAOTest {


	static EmployeeDAO employeeDAO;
	
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		employeeDAO = (EmployeeDAO)context.getBean("employeeDAO");
	}
	
	@Test
	public void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setCourse("CPP");
		employee.setCentreID(00327);
		employee.setEmpName("Rukmani");
		assertTrue("Problem in adding employee", employeeDAO.addEmployee(employee));
	}

}
