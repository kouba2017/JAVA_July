package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Flower;
import com.example.demo.models.User;
import com.example.demo.services.FlowerService;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private FlowerService flowerService;
		@GetMapping("/flowers")
		public String home(HttpSession session, Model model) {
			//guard of route
			 if (session.getAttribute("userId")==null) {
				 return "redirect:/";
			 }
			//get the user so we can access username
			//through the session .get
			Long userId= (Long)session.getAttribute("userId");
			User loggedUser=userService.findById(userId);
			model.addAttribute("user",loggedUser);
			
			//Get all flowers
			model.addAttribute("flowers",flowerService.getAllFlowers());
			return "home.jsp";
		}
		@GetMapping("/flowers/new")
		public String addFlower(HttpSession session,@ModelAttribute("flower")Flower flower ) {
			//guard of route
			 if (session.getAttribute("userId")==null) {
				 return "redirect:/";
			 }
			 
			return "create.jsp";
		}
		@PostMapping("/flowers/create")
		public String createFlower(HttpSession session, @Valid @ModelAttribute("flower")Flower flower,BindingResult result) {
			if(result.hasErrors()) {
				// return the same page
				return "create.jsp";
			}
			Long userId= (Long)session.getAttribute("userId");
			User loggedUser=userService.findById(userId);
			flower.setUser(loggedUser);
			flowerService.createFlower(flower);
			Long id=flower.getId();
			return "redirect:/flowers/"+id;
		}
		@GetMapping("/flowers/{id}/edit")
		public String editFlower(HttpSession session, @PathVariable Long id, Model model,  @ModelAttribute("flower")Flower flower) {
			//guard of route
			 if (session.getAttribute("userId")==null) {
				 return "redirect:/";
			 }
			 model.addAttribute("flower",flowerService.getFlowerById(id));
			return "edit.jsp";
		}
		
		@PutMapping("/flowers/{id}/edit")
		public String editForm(HttpSession session, @PathVariable Long id, Model model, @Valid @ModelAttribute("flower")Flower flower, BindingResult result) {
			//guard of route
			 if (session.getAttribute("userId")==null) {
				 return "redirect:/";
			 }
			 if(result.hasErrors()) {
					// return the same page
				 model.addAttribute("flower",flowerService.getFlowerById(id));
					return "edit.jsp";
				}
			 
			 flowerService.updateFlower(flower);
			 return "redirect:/flowers/{id}";
			
		}
		
		
		@GetMapping("/flowers/{id}")
		public String viewFlower(HttpSession session, @PathVariable Long id, Model model) {
			//guard of route
			 if (session.getAttribute("userId")==null) {
				 return "redirect:/";
			 }
			 model.addAttribute("flower", flowerService.getFlowerById(id));
			return "view.jsp";
		}
		@DeleteMapping("/flowers/{id}")
		public String removeFlower(@PathVariable Long id) {
			flowerService.deleteToDoById(id);
			return "redirect:/flowers";
		}
		@GetMapping("/myflowers/")
		public String viewMyFlowers(HttpSession session) {
			//guard of route
			 if (session.getAttribute("userId")==null) {
				 return "redirect:/";
			 }
			return null;
		}
}
