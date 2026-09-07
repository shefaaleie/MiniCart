package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CartEntity;
import com.example.demo.entity.ProductEntity;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer>{

	CartEntity findByProduct(ProductEntity product);
}
