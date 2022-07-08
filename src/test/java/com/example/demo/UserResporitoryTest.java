package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserResporitoryTest {
	
@Autowired
private UserResporitory repo;

@Autowired
private TestEntityManager entitymanager;

@Transactional
@Test
public void testCreateuser()
{
	user u1 = new user();
	u1.setEmail("chalar@gmail.com");
	u1.setFirstname("chala");
	u1.setLastname("niro");
	u1.setPassword("chala2020");
	
	user savedUser = repo.save(u1);
	
	user exituser= entitymanager.find(user.class, savedUser.getId());
	assertThat(exituser.getEmail()).isEqualTo(u1.getEmail());

			
			}
@Test
public void testuserbyid()
{ String email="chala@gamail.com";
user u1=repo.findByEmail(email);

	}
@Test
public void testpassword()
{
	Password p= new Password();
	
	
	
}
}
