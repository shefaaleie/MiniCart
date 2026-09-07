package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="order")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderId;

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		this.OrderId = orderId;
	}

	private String CustomerName;

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		this.CustomerName = customerName;
	}

	private String PhoneNumber;

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber=phoneNumber;
	}
	private String Address;
	
	public String Address() {
		return Address;
	}
	
	public void setAddress(String address) {
		this.Address=address;
	}

	private int GrandTotal;
	
	public int getGrandtotal() {
		return GrandTotal;
	}
	
	public void setGrandTotal(int grandtotal) {
		this.GrandTotal=grandtotal;
	}
}
