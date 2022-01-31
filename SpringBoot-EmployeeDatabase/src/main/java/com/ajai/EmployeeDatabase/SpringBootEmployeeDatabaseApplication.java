package com.ajai.EmployeeDatabase;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import com.ajai.EmployeeDatabase.DaoLayer.EmployeeRepository;
import com.ajai.EmployeeDatabase.Entity.Employee;
import com.ajai.EmployeeDatabase.Entity.Role;
import com.ajai.EmployeeDatabase.Entity.User;
import com.ajai.EmployeeDatabase.Service.EmployeeService;
	
@SpringBootApplication
public class SpringBootEmployeeDatabaseApplication implements CommandLineRunner {
	
//	@Autowired
//	EmployeeService employeeService;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeDatabaseApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
//		employeeService.saveEmployee(new Employee(1l,"Iemployee1","emp1","emp1@gmail.com"));
//		employeeService.saveEmployee(new Employee(2l,"Kemployee2","emp2","emp2@gmail.com"));
//		employeeService.saveEmployee(new Employee(3l,"Memployee3","emp3","emp3@gmail.com"));
//		employeeService.saveEmployee(new Employee(4l,"Jemployee4","emp4","emp4@gmail.com"));
//		employeeService.saveEmployee(new Employee(5l,"Lemployee5","emp5","emp5@gmail.com"));
//		employeeService.saveEmployee(new Employee(6l,"Nemployee6","emp6","emp6@gmail.com"));
//		
//		employeeService.saveRole(new Role(1l,"ADMIN"));
//		employeeService.saveRole(new Role(2l,"USER"));
//		
//		employeeService.saveUser(new User(1l,"one","$2a$12$U4ifUs0CZzDBpOrGMH5P5.XrQR543/v6/a7uznbiWLInLVSqy4a2O"));
//		employeeService.saveUser(new User(2l,"two","$2a$12$YBPDEp0VgC2fqPV3yFaAw.x4I8hF5sJpM9gSktJOVRJ1G/GIwTYam"));
		
//		employeeService.saveUser(new User(1l,"person1","passwordone"));
//		employeeService.saveUser(new User(2l,"person2","passwordtwo"));
	
		
	}

}
