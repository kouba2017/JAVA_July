package com.example.demo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public User findByEmail(String  email) {
		// we will use Optional class 
		Optional<User> e =userRepo.findByEmail(email);
		if(e.isEmpty()) {
			return null;
		}else {
			return e.get();
		}
	}
    public User findById(Long  id) {
		// we will use Optional class 
		Optional<User> e =userRepo.findById(id);
		if(e.isEmpty()) {
			return null;
		}else {
			return e.get();
		}
	}
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        if(result.hasErrors()) {
        	return null;
        }
      //Password with the confirm
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "match", "Password and Confirm password does not match");
        }
        //IF the email have register : if it exist )=> make sure it is unique
        if(findByEmail(newUser.getEmail())!=null) {
        	result.rejectValue("email", "unique","Email already exists, try to login");
        }
        //bcrypt password
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        
        //update the value of the password
        newUser.setPassword(hashed);
        
        userRepo.save(newUser);
        
        return newUser;
    }
    public User login(LoginUser newLogin, BindingResult result) {
    	 if(result.hasErrors()) {
         	return null;
         }
    	 if(findByEmail(newLogin.getEmail())==null) {
         	result.rejectValue("email", "does not exist","Email does not exist, try to register");
         }
    	 
    	 User user= findByEmail(newLogin.getEmail());
    	 //compare using Bcrypt
    	 if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		 result.rejectValue("password","wrong", "Wrong Credentials!");
    	 }
    	 
    	 
        return user;
    }
}
