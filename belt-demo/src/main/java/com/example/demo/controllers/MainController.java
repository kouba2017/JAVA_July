package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
		@GetMapping("/flowers")
		public String home() {
			return null;
		}
		@GetMapping("/flowers/new")
		public String addFlower() {
			return null;
		}
		@PostMapping("/flowers/create")
		public String createFlower() {
			return null;
		}
		@GetMapping("/flowers/{id}/edit")
		public String editFlower() {
			return null;
		}
		@GetMapping("/flowers/{id}")
		public String viewFlower() {
			return null;
		}
		@DeleteMapping("/flowers/{id}")
		public String removeFlower() {
			return null;
		}
		@GetMapping("/myflowers/")
		public String viewMyFlowers() {
			return null;
		}
}
