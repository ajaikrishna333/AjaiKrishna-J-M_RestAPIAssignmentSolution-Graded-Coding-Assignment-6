package com.ajai.EmployeeDatabase.Controller;

import com.ajai.EmployeeDatabase.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajai.EmployeeDatabase.Entity.Employee;
import com.ajai.EmployeeDatabase.Entity.Role;
import com.ajai.EmployeeDatabase.Service.EmployeeService;

@RestController
@RequestMapping("/controller")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

//	private EmployeeService employeeService;
//	@Autowired
//	public EmployeeController(EmployeeService theEmployeeService) {
//		employeeService = theEmployeeService;
//	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		employeeService.saveUser(user);
		return "user " + user.getUsername() + " added to the database";
	}

	@PostMapping("/saveRole")
	public String saveRole(@RequestBody Role role) {
		employeeService.saveRole(role);
		return "role " + role.getRolename() + " added to the database";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		employee.setEmployee_id(0);
		employeeService.save(employee);
		return "employee " + employee.getFirstname() + " added to the database";
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "employee" + employee.getFirstname() + "has been updated";
	}

	@GetMapping("/findEmployeeById/{employee_id}")
	public Optional<Employee> findEmployeeById(@PathVariable long employee_id) {
//		Optional<Employee> employee = employeeService.findEmployeeById(employee_id);
//
//		if (employee == null) {
//			throw new RuntimeException("Employee with id : " + employee_id + " not found");
//		}
		return employeeService.findEmployeeById(employee_id);
	}

	@GetMapping("/findEmployeeByFirstName/{firstname}")
	public List<Employee> findEmployeeByFirstName(@PathVariable String firstname) {
//		List<Employee> eList = employeeService.findEmployeeByFirstName(firstname);
//
//		if (eList == null) {
//			throw new RuntimeException("Employee with First Name : " + firstname + " not found");
//		}

		return employeeService.findEmployeeByFirstName(firstname);
	}

	@GetMapping("/getAllEmployeesSortedByFirstName/{order}")
	public List<Employee> getAllEmployeesSortedByFirstName(@PathVariable String order) {
		return employeeService.getAllEmployeesSortedByFirstName(order);
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

	@DeleteMapping("/deleteEmployeeById/{employee_id}")
	public String deleteEmployeeById(@PathVariable long employee_id) {

		Optional<Employee> employee = employeeService.findEmployeeById(employee_id);

		if (employee != null) {
			employeeService.deleteEmployeeById(employee_id);
			return "Deleted employee id - " + employee_id;
		} else {
			return "Delete operation failed";
		}

	}

}
