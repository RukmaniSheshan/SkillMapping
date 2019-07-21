package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImplementation implements EmployeeDAO{

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addEmployee(Employee employee) {
		try {
			sessionfactory.getCurrentSession().save(employee);
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			sessionfactory.getCurrentSession().update(employee);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int empID) {
		Employee emp = getEmployee(empID);
		try {
			sessionfactory.getCurrentSession().delete(emp);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Employee> listEmployee() {
		Session session  = sessionfactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> listemployee = query.list();
		session.close();
		return listemployee;
	}

	@Override
	public Employee getEmployee(int empID) {
		Session session  = sessionfactory.openSession();
		Employee employee = (Employee)session.get(Employee.class, empID);
		session.close();
		return employee;
	}
	
	
	@Override
	public Employee getById(int empID) {
		return sessionfactory.getCurrentSession().get(Employee.class, empID);
	}

}
