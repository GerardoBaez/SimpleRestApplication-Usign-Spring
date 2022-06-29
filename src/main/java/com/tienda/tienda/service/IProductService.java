package com.tienda.tienda.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tienda.dto.request.ProductRequestDto;
import com.tienda.dto.response.ProductResponseDto;
import com.tienda.tienda.model.ProductModel;

public interface IProductService {
	
	
	/**
	 * Metodo para traer todos
	 * los productos de la base de datos
	 * @return
	 */
	
	 List<ProductResponseDto> findall();
	 
	 
	 /**
	  * Metodo para encontrar un producto
	  * de acuerdo a su nombre 
	  * @param nombre
	  * @return
	  */
	 
	 ProductResponseDto findByName(String nombre );
	 
	 
	 
	 /**
	  * Metodo para encontrar un producto
	  * de acuerdo a su nombre 
	  * @param nombre
	  * @return
	  */
	 
	 ProductResponseDto finbyId(Integer id);
	 
	 
	 /**
	  * Metodo para crear un nuevo producto
	  * @param product
	  * @return
	  */
	 ProductResponseDto saveproduct(ProductRequestDto product); 
	 
	 
	 /**
	  * Metodo para eliminar
	  * un producto
	  * @param nombre nombre del producto a eliminar
	 * @return 
	  */
	 void deleteproduct(String nombre);
	 
	 
	 /**
	  * Cambiar campos de
	  * un producto
	  * @param id
	  * @param productmodel
	  * @return
	  */
	 ResponseEntity<?> changeproduct(ProductRequestDto productmodel);
	 

}
