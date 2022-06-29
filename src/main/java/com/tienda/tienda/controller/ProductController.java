package com.tienda.tienda.controller;

import java.net.URI;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tienda.dto.request.ProductRequestDto;
import com.tienda.dto.response.ProductResponseDataDto;
import com.tienda.dto.response.ProductResponseDto;
import com.tienda.tienda.model.ProductModel;
import com.tienda.tienda.service.IProductService;
import com.tienda.tienda.service.ProductRepository;
import com.tienda.tienda.service.ProductService;
import com.tienda.tienda.services.exeptions.ProductNotFoundExeption;

@RestController

public class ProductController {
	
	
	private ProductRepository productrepo;
	
	
	
	@Autowired
	private IProductService productservice;
	
	
	//GET ALL PRODUCTS
	@GetMapping("/products")
	public ResponseEntity<?> retrieveProducts(){
		
		//Dto respuesta
		ProductResponseDataDto productresponsedatadto= new ProductResponseDataDto();
		
		List<ProductResponseDto> productos = productservice.findall();
		
		productresponsedatadto.setData(productos);
		
		
		
		return new ResponseEntity<>(productresponsedatadto ,HttpStatus.OK);
		
	}
	
	
	
	// FIND BY NAME
	@GetMapping("/products/findbyname")
	public ResponseEntity<?> retrieveProductByName(@RequestParam (name="nombre", required= true ) String nombre)  {
		
		//Dto respuesta
		
		ProductResponseDto productresponsedto=new ProductResponseDto();
		
		productresponsedto = productservice.findByName(nombre);
		
		
		return new ResponseEntity<>(productresponsedto ,HttpStatus.OK);	
		
	}

	
	
	
	// FIND BY ID
	@GetMapping("/products/findbyid")
	public ResponseEntity<?> retrieveProductById(@RequestParam(name="id",required=true) Integer id) {
		
		//Dto respuesta
		
		ProductResponseDto productresponsedto=new ProductResponseDto();
		
		productresponsedto = productservice.finbyId(id);
		
		
		return new ResponseEntity<>(productresponsedto ,HttpStatus.OK);	
		
		
	}
	
	
	

	//POST A PRODUCT
	
	@PostMapping("/products")
	public ResponseEntity<Object> createpost(@Valid @RequestBody ProductRequestDto product) {
		//Dto respuesta
		ProductResponseDto productresponsedto=new ProductResponseDto();
		
		productresponsedto = productservice.saveproduct(product);
		
		
		return new ResponseEntity<>(productresponsedto ,HttpStatus.OK);	
		
		
	}
	
	
	//DELETE A PRODUCT
	@DeleteMapping("/products")
	public ResponseEntity<?> deleteProductById(@RequestParam (name="nombre", required=true) String nombre) {
		
		productservice.deleteproduct(nombre);
		
		return new ResponseEntity<>("El producto fue borrado exitosamente",HttpStatus.OK);	
		
	}
	
	
	//PUT A PRODUCT
	@PutMapping("/products")
	public ResponseEntity<?> changeproduct(@Valid  @RequestBody ProductRequestDto product){
		
		return  productservice.changeproduct(product);
	}
	
	
	
	
	/**
	
	//PATCH A PRODUCT 
	@PatchMapping("/products/{id}/setname")
	public ResponseEntity<Object> updateProductName(@RequestParam(name="nombre", required=true) String nombre, @RequestBody ProductRequestDto product ) {
		
		
			
		
	}
	
	**/
	
	
	
	

}
