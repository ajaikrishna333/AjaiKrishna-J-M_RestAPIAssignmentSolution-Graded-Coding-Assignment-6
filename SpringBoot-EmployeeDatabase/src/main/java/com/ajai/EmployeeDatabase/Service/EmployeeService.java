package com.ajai.EmployeeDatabase.Service;

import java.util.List;
import java.util.Optional;

import com.ajai.EmployeeDatabase.Entity.Employee;
import com.ajai.EmployeeDatabase.Entity.Role;
import com.ajai.EmployeeDatabase.Entity.User;

public interface EmployeeService {
	
	public List<Employee> findAllEmployee();
	
	public Optional<Employee> findEmployeeById(long employee_id);
	
	public List<Employee> findEmployeeByFirstName(String firstname); 
	
	public void save(Employee employee);
	
	public void deleteEmployeeById(long employee_id);
	
	public List<Employee> getAllEmployeesSortedByFirstName(String order);
	
	public void saveUser(User user);
	
	public void saveRole(Role role); 
 
}
