package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Flower;
import com.example.demo.repositories.FlowerRepository;
@Service
public class FlowerService {
	// link the repository 
		@Autowired
		FlowerRepository flowerRepo;
		
		// method to get all flowers
		public List<Flower> getAllFlowers(){
			return flowerRepo.findAll();
		}
		
		// create flower 
		public Flower createFlower(Flower flower) {
			return flowerRepo.save(flower);
		}
		
	
		
		// delete flower 
		public void deleteToDoById(Long id) {
			flowerRepo.deleteById(id);
		}
		
		//update flower 
		public Flower updateFlower(Flower newFlower) {
			
			return flowerRepo.save(newFlower);
		}
		
		// find flower byid
		public Flower getFlowerById(Long id) {
			// we will use Optional class 
			Optional<Flower> flower =flowerRepo.findById(id);
			if(flower.isEmpty()) {
				return null;
			}else {
				return flower.get();
			}
		}

}
