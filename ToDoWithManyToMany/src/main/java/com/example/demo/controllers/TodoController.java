package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;
	@Autowired 
	UserService userService;
	//get the main page (table of todos)
	@GetMapping("/todos")
	public String index(Model model) {
		// i will get all the todos and pass them into the Model
		model.addAttribute("todos",todoService.getAllTodos());
		model.addAttribute("userList",userService.getAllUsers());
		return "todos.jsp";
	}

	
	//get create todo page 
	@GetMapping("/todos/create")
	public String createPage(@ModelAttribute("todo")Todo todo, Model model) {
		model.addAttribute("userList",userService.getAllUsers());
		return "createTodo.jsp";
	}
	
	//submit data to create todo 
	@PostMapping("/todos/create")
	public String createTodo(@Valid @ModelAttribute("todo")Todo todo,BindingResult result, Model model) {
		
		// if there is validation errors related to the modelAttribute
		if(result.hasErrors()) {
			// return the same page
			model.addAttribute("userList",userService.getAllUsers());
			return "createTodo.jsp";
		}
		
		
	//else 
		// i will persist the data in the DB 
		todoService.createTodo(todo);
		// redirect /todos (main page )
		return "redirect:/todos";
		
	}
	//get edit todo page 
	@GetMapping("/todos/edit/{id}")
	public String editPage(@ModelAttribute("todo")Todo todo,Model model,@PathVariable("id") Long id) {
		Todo todoDisplay=todoService.getToDoById(id);
		model.addAttribute("todoOne",todoDisplay);
		return "editTodo.jsp";
	}
	//Put method
	@PutMapping("/todos/edit/{id}")
	public String editTodo(@Valid @ModelAttribute("todo")Todo todo,BindingResult result,@PathVariable("id")Long id, Model model) {
		
		// if there is validation errors related to the modelAttribute
		if(result.hasErrors()) {
			// return the same page 
			Todo todoDisplay=todoService.getToDoById(id);
			model.addAttribute("todoOne",todoDisplay);
			return "editTodo.jsp";
		}
		
		
	//else 
		// i will persist the data in the DB 
		todoService.updateTodo(todo);
		// redirect /todos (main page )
		return "redirect:/todos";
		
	}
	//get edit todo page 
		@GetMapping("/todos/{id}")
		public String oneshowPage(Model model,@PathVariable("id") Long id) {
			Todo todoDisplay=todoService.getToDoById(id);
			model.addAttribute("todoOne",todoDisplay);
			return "oneTodo.jsp";
		}
	//delete todo 
	@GetMapping("/todos/delete/{id}")
	public String deleteToDO(@PathVariable("id")Long id) {
		todoService.deleteToDoById(id);
		return "redirect:/todos";
	}
	
	// search by title contains 
	@GetMapping("/todos/search")
	public String search(@RequestParam("query")String query,Model model) {
		List<Todo> searchedTodos =todoService.searchByTitle(query);
		model.addAttribute("todos",searchedTodos);
		return "todos.jsp";
	}
}
