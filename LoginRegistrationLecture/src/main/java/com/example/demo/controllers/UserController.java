package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

//.. don't forget to include all your imports! ..

@Controller
public class UserController {
 
 // Add once service is implemented:
 @Autowired
 private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model, @ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin) {
 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
    // model.addAttribute("newUser", new User());
     //model.addAttribute("newLogin", new LoginUser());
     return "index.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
	 User userInDb=userServ.register(newUser, result);
     // to do some extra validations and create a new user!
     
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     session.setAttribute("userId", userInDb.getId());
     // in other words, log them in.
 
     return "redirect:/home";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
     User user = userServ.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", user.getId());

     return "redirect:/home";
 }
 @GetMapping("/home")
 public String home(Model model,HttpSession session) {
	 //guard of route
	 if (session.getAttribute("userId")==null) {
		 return "redirect:/";
	 }
	 Long userId=(Long)session.getAttribute("userId");
	 User userLogged=userServ.findById(userId);
	 model.addAttribute("user", userLogged);
	 return "home.jsp";
 }
 
 @GetMapping("/logout")
 public String logout (HttpSession session) {
	 session.invalidate();
	 return "redirect:/";
 }
 
 
}
