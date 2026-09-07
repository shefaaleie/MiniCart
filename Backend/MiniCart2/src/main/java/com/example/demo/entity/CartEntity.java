package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int CartId) {
		this.cartId=CartId;
	}
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;
	
	public ProductEntity getProduct() {
		return product;
	}
	
	public void setProduct(ProductEntity Product) {
		this.product=Product;
	}
	
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int Quantity) {
		this.quantity=Quantity;
	}
	
}
