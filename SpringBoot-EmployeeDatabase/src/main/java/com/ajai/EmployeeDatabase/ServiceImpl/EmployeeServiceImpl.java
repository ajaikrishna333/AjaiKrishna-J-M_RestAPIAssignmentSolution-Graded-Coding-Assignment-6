package com.ajai.EmployeeDatabase.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ajai.EmployeeDatabase.DaoLayer.EmployeeRepository;
import com.ajai.EmployeeDatabase.DaoLayer.RoleRepository;
import com.ajai.EmployeeDatabase.DaoLayer.UserRepository;
import com.ajai.EmployeeDatabase.Entity.Employee;
import com.ajai.EmployeeDatabase.Entity.Role;
import com.ajai.EmployeeDatabase.Entity.User;
import com.ajai.EmployeeDatabase.Service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	PasswordEncoder bcryptEncoder;


//	private EmployeeRepository employeeRepository;
//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
//		employeeRepository = theEmployeeRepository;
//	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Employee> findAllEmployee() {
//		List<Employee> eList = employeeRepository.findAll();
		
		Employee employee = new Employee();
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIgnorePaths("firstname","employee_id", "lastname", "email_id");
		Example<Employee> example = Example.of(employee, exampleMatcher);

		List<Employee> eList = employeeRepository.findAll(example);
		
		if (eList.isEmpty()) {
			throw new RuntimeException("No Employees found in Database");
		}
		return eList;
	}

	@Override
	public Optional<Employee> findEmployeeById(long employee_id) {
		Optional<Employee> employee = employeeRepository.findById(employee_id);

		if (employee == null) {
			throw new RuntimeException("Employee with id : " + employee_id + " not found");
		}

		return employee;
	}

	@Override
	public List<Employee> findEmployeeByFirstName(String firstname) {
		Employee employee = new Employee();
		employee.setFirstname(firstname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstname", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("employee_id", "lastname", "email_id");
		Example<Employee> example = Example.of(employee, exampleMatcher);

		List<Employee> eList = employeeRepository.findAll(example);

		if (eList.isEmpty()) {
			throw new RuntimeException("Employee with First Name : " + firstname + " not found");
		}

		return eList;
	}

	@Override
	public List<Employee> getAllEmployeesSortedByFirstName(String order) {
		
		List<Employee> eList = new ArrayList<Employee>();
		
		if(order.equals("ASC")) {
			eList = employeeRepository.findAll(Sort.by("firstname"));
		}else if (order.equals("DESC")){
			eList = employeeRepository.findAll(Sort.by(Direction.DESC,"firstname"));
		}
		if (eList.isEmpty()) {
			throw new RuntimeException("No Employees found in Database");
		}
		return eList;
	}

	@Override
	public void deleteEmployeeById(long employee_id) {
		employeeRepository.deleteById(employee_id);
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void saveUser(User user) {
//		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

}
