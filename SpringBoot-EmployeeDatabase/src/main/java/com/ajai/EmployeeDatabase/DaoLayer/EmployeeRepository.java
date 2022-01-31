package com.ajai.EmployeeDatabase.DaoLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajai.EmployeeDatabase.Entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
