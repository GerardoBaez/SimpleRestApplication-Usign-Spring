package com.tienda.tienda.services;

import java.net.URI;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tienda.tienda.entities.Product;
import com.tienda.tienda.services.exeptions.ProductNotFoundExeption;

@RestController

public class ProductJPAResource {
	
	@Autowired
	private ProductRepository productrepo;
	
	
	//GET ALL PRODUCTS
	@GetMapping("/products")
	public List<Product>retrieveProducts(){
		return productrepo.findAll();
		
	}
	
	
	// GET A SINGLE PRODUCT
	@GetMapping("/products/{id}")
	public Optional<Product> retrieveProduct(@PathVariable Integer id) {
		Optional<Product>opproduct=productrepo.findById(id);
		 if(!opproduct.isPresent())
			 throw new ProductNotFoundExeption("id"+id);
		 return opproduct;
		
		
	}
	
	//POST A PRODUCT
	
	@PostMapping("/products")
	public ResponseEntity<Object> createpost(@Valid @RequestBody Product product) {
		Product savedproduct = productrepo.save(product);
		URI location= ServletUriComponentsBuilder.
				fromCurrentRequest().path("{id}")
				.buildAndExpand(savedproduct.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	//DELETE A PRODUCT
	@DeleteMapping("/products/{id}")
	public void deleteProductById(@PathVariable Integer id) {
		Optional<Product> opproduct =productrepo.findById(id);
		if(!opproduct.isPresent()) 
			 throw new ProductNotFoundExeption("id"+id);
		
		productrepo.deleteById(id);
		
	
		
	}
	
	
	//PUT A PRODUCT
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> changeproduct(@PathVariable Integer id, @RequestBody Product product){
		Optional<Product> opproduct = productrepo.findById(id);
		if (!opproduct.isPresent())
			 throw new ProductNotFoundExeption("id"+id);
		
		Product pchange= opproduct.get();
		pchange.setId(id);
		pchange.setNombre(product.getNombre());
		pchange.setPrecio(product.getPrecio());
	
		productrepo.save(pchange);
		return ResponseEntity.noContent().build();
	
	}
	
	
	
	
	/*
	//PATCH A PRODUCT NAME
	@PatchMapping("/products/{id}/setname")
	public ResponseEntity<Object> updateProductName(@PathVariable Integer id, Product product) {
		Optional<Product> opproduct = productrepo.findById(id);
		if (!opproduct.isPresent())
			 throw new ProductNotFoundExeption("id"+id);
		Product pchange= opproduct.get();
		pchange.setId(id);
		pchange.setNombre(product.getNombre());
		productrepo.save(pchange);
		
		return ResponseEntity.noContent().build();
		
	}
	
	*/
	
	
	

}
