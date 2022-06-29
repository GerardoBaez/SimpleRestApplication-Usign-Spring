package com.tienda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase contiene
 * la informacion 
 * acerca de un producto 
 * @author Gerardo
 *
 */



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

	
	private String nombre;
	
	
	private Double precio;
	
	
	private String makername;
	
	
}
