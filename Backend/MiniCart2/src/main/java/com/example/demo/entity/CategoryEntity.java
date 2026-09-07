package com.example.demo.entity;

import jakarta.persistence.*;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	public void setCategoryId(int categoryId) {
		this.categoryId=categoryId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	
	
	private String categoryName;
	
	
	public void setCategoryName(String categoryName) {
		this.categoryName=categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	
}
