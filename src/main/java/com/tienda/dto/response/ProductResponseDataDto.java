package com.tienda.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDataDto {
	
	
	List<ProductResponseDto> data= new ArrayList<>();

}
