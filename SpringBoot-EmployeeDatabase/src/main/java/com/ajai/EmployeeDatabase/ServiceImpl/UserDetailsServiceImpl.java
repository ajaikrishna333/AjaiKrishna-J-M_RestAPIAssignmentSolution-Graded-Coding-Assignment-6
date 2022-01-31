package com.ajai.EmployeeDatabase.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ajai.EmployeeDatabase.DaoLayer.UserRepository;
import com.ajai.EmployeeDatabase.Entity.User;
import com.ajai.EmployeeDatabase.security.MyCustomUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Username does not exists");
        }
         
        return new MyCustomUserDetails(user);
	}

}
