package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String HealthCheck() {
		return "Working Fine";
	}

	@PostMapping("create")
	public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
		return categoryService.addCategory(category);
	}

	@GetMapping("getAllCategories")
	public List<CategoryEntity> getAll() {
		return categoryService.getAll();
	}

	@GetMapping("getCategoryById/{id}")
	public CategoryEntity getCategory(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}

	@PutMapping("updateCategory/{id}")
	public CategoryEntity updateCategory(@RequestBody CategoryEntity category, @PathVariable int id) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		boolean deleted = categoryService.deleteCategory(id);

		if (deleted) {
			return "Category Deleted!";
		}
		return "Category Not Found!";
	}

}
