package com.example.demo;
import javax.persistence.*;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name="users")
@Transactional(propagation = Propagation.NESTED)
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private Long id;
	private String email; 
	private String firstname;
	private String lastname;
	private String password;
public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
