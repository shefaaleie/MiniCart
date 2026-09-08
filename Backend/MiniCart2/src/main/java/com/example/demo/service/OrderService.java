package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.repositories.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	public OrderEntity addOrder(OrderEntity order) {
		return orderRepo.save(order);
	}

	public List<OrderEntity> getAllOrders() {
		return orderRepo.findAll();
	}

	public OrderEntity getOrderById(int id) {
		return orderRepo.findById(id).orElse(null);
	}

	public OrderEntity updateOrder(int id, OrderEntity order) {
		OrderEntity existingOrder = orderRepo.findById(id).orElse(null);

		if (existingOrder != null) {
			existingOrder.setCustomerName(order.getCustomerName());
			existingOrder.setAddress(order.getAddress());
			existingOrder.setPhoneNumber(order.getPhoneNumber());
			return orderRepo.save(existingOrder);
		} else
			return null;

	}

	public Boolean deleteOrder(int id) {
		if(orderRepo.existsById(id)) {
			orderRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
