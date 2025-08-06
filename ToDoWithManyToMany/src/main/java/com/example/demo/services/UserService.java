package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	// method to get all users
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	// create user 
	public User createUser(User user) {
		return userRepo.save(user);
	}
	public User getUserById(Long id) {
		// we will use Optional class 
		Optional<User> user =userRepo.findById(id);
		if(user.isEmpty()) {
			return null;
		}else {
			return user.get();
		}
	}
	
	// delete user 
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
	
	//update user 
	public User updateUser(User newUser) {
		
		return userRepo.save(newUser);
	}
}
