package com.example.demo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=50, message="The name must at least be 2 characters")
	@NotBlank
	private String name;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Todo> myTodos;
	 @PrePersist
	 protected void onCreate() {
		 this.createdAt=new Date();
		 this.updatedAt=new Date();
	 }
	 
	 @PreUpdate
	 protected void onUpdate() {
		 this.updatedAt=new Date();
	 }
	 
	 public User() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Todo> getMyTodos() {
		return myTodos;
	}

	public void setMyTodos(List<Todo> myTodos) {
		this.myTodos = myTodos;
	}
	
	 
}
