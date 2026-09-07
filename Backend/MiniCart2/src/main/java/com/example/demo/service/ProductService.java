package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired	
	private ProductRepo productRepo;
	
	public ProductEntity createProduct(ProductEntity product) {
		return productRepo.save(product);
	}
	
	public List<ProductEntity> getAll(){
		return productRepo.findAll();
	}
	
	public ProductEntity getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public ProductEntity  updateProduct(int productId,ProductEntity product) {
		
		ProductEntity existingProduct=productRepo.findById(productId).orElse(null);
		
		if(existingProduct!=null) {
			existingProduct.setProductName(product.getProductName());
			existingProduct.setImage(product.getImage());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setCategory(product.getCategory());
			
		return productRepo.save(existingProduct);
		}
		
		return null;
	}
	
	public boolean deleteProduct(int id) {
		if(productRepo.existsById(id)) {
			productRepo.deleteById(id);;
			return true;
		}
		return false;
	}
	
	
	
}
