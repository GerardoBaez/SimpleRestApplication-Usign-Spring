package com.tienda.tienda.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tienda.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
}
