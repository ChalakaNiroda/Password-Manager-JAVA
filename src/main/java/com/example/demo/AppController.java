package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;





@SuppressWarnings("unused")
@RestController
public class AppController {
	
	@Autowired
	private UserResporitory repo;


	
	@GetMapping("")
	public String viewhomepage()
	{
		return "index.html";
	}
	@GetMapping("/register")
	public String showsignup (Model model)
	{
		model.addAttribute("user",new user());
		return "register.html";
	}
	

	@GetMapping("/ps_register")
	public String psregister (Model model)
	{
		model.addAttribute("Password",new Password());
		return "psregister.html";
	}
	@GetMapping("/list_password")
	public String show(Model model) {
		 CustomerUserDetails userDetails = (CustomerUserDetails) SecurityContextHolder.getContext().getAuthentication()
	             .getPrincipal();
	Long id1 = userDetails.getid();
	List<Password> listpassword = repp.findByuserid(id1);
	model.addAttribute("listpassword", listpassword);
	
		return "cushome.html";
	}
	@PostMapping("/process_register")
	public String processreg(user u1)
	{

		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	     String encordedparssword=encoder.encode(u1.getPassword());
	     u1.setPassword(encordedparssword);
		repo.save(u1);
		return "index.html";
	}
	@Autowired
	private PasswordRepository repp;

	
	@PostMapping("/psprocess_register")
	public String psprocessreg(Password p1)
	{

	
	     CustomerUserDetails userDetails = (CustomerUserDetails) SecurityContextHolder.getContext().getAuthentication()
             .getPrincipal();
Long id1 = userDetails.getid();
Date dnow=new Date();

p1.setDatecreated(dnow);
p1.setDatemodify(dnow);
p1.setUserid(id1);
	     
	     
		repp.save(p1);
		return "redirect:/list_password";
	}
	
	@GetMapping("deletePassword/{id}")
	public String  deletePassword(@PathVariable (value = "id")Long id)
	{
		repp.deleteById(id);
		return "redirect:/list_password";
	
	}
	
}
