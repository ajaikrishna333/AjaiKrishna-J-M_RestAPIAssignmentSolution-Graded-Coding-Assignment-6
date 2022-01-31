package com.ajai.EmployeeDatabase.DaoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ajai.EmployeeDatabase.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User getUserByUsername(String username);
	
}
