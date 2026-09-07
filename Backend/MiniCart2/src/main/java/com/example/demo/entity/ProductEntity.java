package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productid) {
		this.productId = productid;
	}

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productname) {
		this.productName = productname;
	}

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double Price) {
		this.price = Price;
	}

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String Image) {
		this.image = Image;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity Category) {
		this.category = Category;
	}

}
