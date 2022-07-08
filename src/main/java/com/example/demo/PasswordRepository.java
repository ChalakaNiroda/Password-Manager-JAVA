package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

	
	public List<Password> findByuserid(Long id);
	public Password getPasswordBypid(Long id);
	

	
}
