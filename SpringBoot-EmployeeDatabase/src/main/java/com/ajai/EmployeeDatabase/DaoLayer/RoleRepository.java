package com.ajai.EmployeeDatabase.DaoLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajai.EmployeeDatabase.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
