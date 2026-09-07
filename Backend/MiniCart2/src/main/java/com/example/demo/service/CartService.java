package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CartEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repositories.CartRepo;
import com.example.demo.repositories.ProductRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ProductRepo productRepo;

	public CartEntity createCart(CartEntity cart) {
		CartEntity existingCartproduct = cartRepo.findByProduct(cart.getProduct());
		if (existingCartproduct != null) {
			existingCartproduct.setQuantity(existingCartproduct.getQuantity() + cart.getQuantity());
			return cartRepo.save(existingCartproduct);
		}
		return cartRepo.save(cart);
	}

	public List<CartEntity> getAll() {
		return cartRepo.findAll();
	}

	public CartEntity getById(int id) {
		return cartRepo.findById(id).orElse(null);
	}

	public CartEntity updateCart(int id, CartEntity cart) {
		CartEntity existingCart = cartRepo.findById(id).orElse(null);

		if (existingCart != null) {
			existingCart.setProduct(cart.getProduct());
			existingCart.setQuantity(cart.getQuantity());
			return cartRepo.save(existingCart);
		}
		return null;
	}

	public boolean deleteCart(int id) {
		if (cartRepo.existsById(id)) {
			cartRepo.deleteById(id);
			return true;
		}
		return false;
	}

	// calculating Grandtotal

	public double calculateGrandTotal() {

		List<CartEntity> cartItems=cartRepo.findAll();
		return cartItems.stream().mapToDouble
				(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
				.sum();

	}
	
	public CartEntity updateQuantity(int id,CartEntity cart) {
		CartEntity existingcart=cartRepo.findById(id).orElse(null);
		
		if(existingcart!=null) {
			existingcart.setQuantity(cart.getQuantity());
			return cartRepo.save(existingcart);
		}
		return null;
	}

}
