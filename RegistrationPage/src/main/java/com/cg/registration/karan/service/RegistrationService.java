package com.cg.registration.karan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.registration.karan.model.User;
import com.cg.registration.karan.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
   public User saveUser(User user) {
	  return  repo.save(user);
	   
   }
   public User fetchUserByEmailId(String email) {
	 return  repo.findByEmailId(email);
   }
   public User fetchUserByEmailIdAndPassword(String email, String password) {
		 return  repo.findByEmailIdAndPassword(email, password);
	   }
	   
	
}
