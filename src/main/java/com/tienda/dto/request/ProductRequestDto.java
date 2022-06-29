package com.tienda.dto.request;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
	
	private String nombre;
	
	private Double precio;
	
	private String  nombremaker;

}
