package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
