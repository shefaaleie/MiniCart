package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		return productService.createProduct(product);
	}
	
	@GetMapping
	public List<ProductEntity> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public ProductEntity getById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("updateProduct/{id}")
	public ProductEntity updateProduct(@PathVariable int id,@RequestBody ProductEntity product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		
		boolean deleted=productService.deleteProduct(id);
		if(deleted) {
			return "Product Deleted!!";
		}
		return "Product Not Found!!";
	}
}
