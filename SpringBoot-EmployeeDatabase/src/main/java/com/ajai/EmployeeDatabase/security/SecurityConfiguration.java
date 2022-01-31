package com.ajai.EmployeeDatabase.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ajai.EmployeeDatabase.ServiceImpl.UserDetailsServiceImpl;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource datasource;
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.userDetailsService(getUserDetailsService()).passwordEncoder(getPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/h2-console/**");
	}

	protected void configure(HttpSecurity http) throws Exception {
//		
		
//		http.csrf().disable().authorizeRequests()
//		.antMatchers("/controller/saveEmployee", "/controller/deleteEmployeeById", "/controller/updateEmployee").hasAuthority("ADMIN")
//		.antMatchers("/controller/getAllEmployee","/controller/user","/controller/role","/controller/findEmployeeById",
//				"/controller/findEmployeeByFirstName","/controller/getAllEmployeesSortedByFirstName")
//		.hasAnyAuthority("ADMIN","USER").and().formLogin();
		

			http.authorizeRequests()
			.antMatchers("/h2-console/").permitAll()
			.antMatchers("/controller/saveEmployee","/controller/deleteEmployeeById","/controller/updateEmployee")
			.hasAuthority("ADMIN")
			.antMatchers("/controller/user", "/controller/role", "/controller/findEmployeeById",
				"/controller/findEmployeeByFirstName", "/controller/getAllEmployeesSortedByFirstName",
				"/controller/findAllEmployee")
			.hasAnyAuthority("USER","ADMIN")
			.anyRequest().authenticated()
			.and().formLogin()
            .and()
            .cors().and().csrf().disable();
	}

}
