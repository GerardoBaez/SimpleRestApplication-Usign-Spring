package com.tienda.tienda.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tienda.tienda.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel,Integer>  ,JpaSpecificationExecutor {
	public Optional<ProductModel> findByNombre(String nombre);
	
}
