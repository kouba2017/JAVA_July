package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired 
	UserService userService;
	// create a new user
	@GetMapping("/user/new")
	public String create (@ModelAttribute("user") User user) {
		return "createUser.jsp";
	}
	
	@PostMapping ("/user/create")
	 public String add (@Valid @ModelAttribute ("user") User user , BindingResult result ) {
		if (result.hasErrors()) {
			return "createUser.jsp";
		}
		userService.createUser(user);
		return "redirect:/todos";
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public String deleteUser(@PathVariable Long userId ) {
		userService.deleteUserById(userId);
		return "redirect:/todos";
	}
	
}
