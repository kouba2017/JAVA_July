package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Flower;

public interface FlowerRepository  extends CrudRepository<Flower, Long> {
	    
	    List<Flower> findAll();
	    
	}
