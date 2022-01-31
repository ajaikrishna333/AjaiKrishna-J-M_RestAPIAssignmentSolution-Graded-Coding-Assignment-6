package com.ajai.EmployeeDatabase.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_table")
@Data
public class Employee { 
	
//	public Employee () {}
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employee_id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email_id")
	private String email_id;
	
	
//	public Employee(String firstname, String lastname, String email_id) {
//		super();
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.email_id = email_id;
//	}
//
//	public long getEmployee_id() {
//		return employee_id;
//	}
//
//	public void setEmployee_id(int employee_id) {
//		this.employee_id = employee_id;
//	}
//
//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getEmail_id() {
//		return email_id;
//	}
//
//	public void setEmail_id(String email_id) {
//		this.email_id = email_id;
//	}
	
		
	
}
