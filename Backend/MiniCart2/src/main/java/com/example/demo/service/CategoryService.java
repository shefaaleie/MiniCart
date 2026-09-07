package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repositories.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public CategoryEntity addCategory(CategoryEntity category) {
		return categoryRepo.save(category);
	}

	public List<CategoryEntity> getAll() {
		return categoryRepo.findAll();
	}

	public CategoryEntity getCategoryById(int id) {
		return categoryRepo.findById(id).orElse(null);
	}

	public CategoryEntity updateCategory(int id, CategoryEntity category) {

		CategoryEntity existingCategory = categoryRepo.findById(id).orElse(null);

		if (existingCategory != null) {
			existingCategory.setCategoryName(category.getCategoryName());
			return categoryRepo.save(existingCategory);

		}
		return null;
	}

	public boolean deleteCategory(int id) {
		if (categoryRepo.existsById(id)) {
			categoryRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
