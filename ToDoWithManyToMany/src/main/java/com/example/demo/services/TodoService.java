package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Todo;
import com.example.demo.repositories.TodoRepository;



@Service
public class TodoService {

	// link the repository 
	@Autowired
	TodoRepository todoRepo;
	
	// method to get all todos
	public List<Todo> getAllTodos(){
		return todoRepo.findAll();
	}
	
	// create todo 
	public Todo createTodo(Todo todo) {
		return todoRepo.save(todo);
	}
	
	// search by title contains 
	public List<Todo> searchByTitle(String query){
		return todoRepo.findByTitleContains(query);
	}
	
	// delete todo 
	public void deleteToDoById(Long id) {
		todoRepo.deleteById(id);
	}
	
	//update todo 
	public Todo updateTodo(Todo newTodo) {
		
		return todoRepo.save(newTodo);
	}
	
	// find todo byid
	public Todo getToDoById(Long id) {
		// we will use Optional class 
		Optional<Todo> todo =todoRepo.findById(id);
		if(todo.isEmpty()) {
			return null;
		}else {
			return todo.get();
		}
	}

}

