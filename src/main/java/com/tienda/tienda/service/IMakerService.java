package com.tienda.tienda.service;

import java.util.List;
import java.util.Optional;

import com.tienda.dto.response.MakerResponseDto;
import com.tienda.tienda.model.MakerModel;

public interface IMakerService {
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<MakerResponseDto> findAll();
	
	
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
    MakerResponseDto findByName(String nombre);
    
    /**
     * 
     * @param id
     * @return
     */
    MakerResponseDto findById(Integer id); 
    
    
    
    MakerResponseDto saveMaker(MakerModel makermodel);
	

}
