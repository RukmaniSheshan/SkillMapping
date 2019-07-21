package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.EmployeeDAOImplementation;
import com.niit.model.Employee;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {

	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean(name = "sessiofactory")
	public SessionFactory getSessionFactory() {
		Properties hproperties = new Properties();
		hproperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hproperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		LocalSessionFactoryBuilder localSession = new LocalSessionFactoryBuilder(getH2DataSource());
		localSession.addProperties(hproperties);
		localSession.addAnnotatedClass(Employee.class);
		
		SessionFactory sessionfactory = localSession.buildSessionFactory();
		return sessionfactory;
	}
	
	@Bean(name = "transactionmanager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory) {
		return new HibernateTransactionManager(sessionfactory);
	}
	
	@Bean(name="employeeDAO")
	public EmployeeDAOImplementation getEmployeeDAOImplementation() {
		return new EmployeeDAOImplementation();
	}
}
