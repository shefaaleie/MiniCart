package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CartEntity;
import com.example.demo.repositories.ProductRepo;
import com.example.demo.service.CartService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	

	
	@PostMapping("create")
	public CartEntity addCart(@RequestBody CartEntity cart) {
		return cartService.createCart(cart);
		
	}
	
	@GetMapping
	public List<CartEntity> getAll(){
		return cartService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public CartEntity getById(@PathVariable int id) {
		return cartService.getById(id);
	}
	
	@PutMapping("update/{id}")
	public CartEntity updateCart(@PathVariable int id, @RequestBody CartEntity cart) {
		return cartService.updateCart(id, cart);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteCart(@PathVariable int id) {
		boolean deleted=cartService.deleteCart(id);
		if(deleted) {
			return "Cart item Deleted Successfully!";
		}
		return "Couldn't find the item!";
	}


	@GetMapping("getGrandTotal")
	public double getGrandTotal() {
		return cartService.calculateGrandTotal();
	}
	
	@PatchMapping("updateQuantity/{id}")
	public CartEntity updateQuantity(@PathVariable int id, @RequestBody CartEntity cart) {
		return cartService.updateQuantity(id, cart);
	}
}
