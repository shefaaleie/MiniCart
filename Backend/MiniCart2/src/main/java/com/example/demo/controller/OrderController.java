package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("create")
	public OrderEntity createOrder(@RequestBody OrderEntity order) {
		return orderService.addOrder(order);
	}
	
	@GetMapping("healthcheck")
	public String HealthCheck() {
		return "hello";
	}

	@GetMapping
	public List<OrderEntity> getOrderList() {
		return orderService.getAllOrders();
	}

	@GetMapping("{id}")
	public OrderEntity getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}

	@PutMapping("{id}")
	public OrderEntity updateOrder(@PathVariable int id, @RequestBody OrderEntity order) {
		return orderService.updateOrder(id, order);
	}

	@DeleteMapping("{id}")
	public String deleteOrder(@PathVariable int id) {
		if (orderService.deleteOrder(id)) {
			return "Order Deleted Successfully!";
		}
		return "Cannot Find Order";
	}

}
