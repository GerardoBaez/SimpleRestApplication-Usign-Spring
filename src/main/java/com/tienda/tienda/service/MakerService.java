package com.tienda.tienda.service;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tienda.dto.response.MakerResponseDto;
import com.tienda.tienda.model.MakerModel;
import com.tienda.tienda.services.exeptions.MakerDuplicateException;
import com.tienda.tienda.services.exeptions.MakerNotFoundExeption;

@Service
public class MakerService implements IMakerService  {
	
	/**
	 * Repositorio de  Maker
	 */
	@Autowired
	private MakerRepository mrepo;
	
	
	/**
	 * Metodo para 
	 * retornar todos
	 * los makers registrados
	 * @return
	 */
	public List<MakerResponseDto> findAll() {
		
		
		//Lista respuesta
		List<MakerResponseDto> listamakersres= new ArrayList<>();
		
	
		//Se consulta en repositorio
		List<MakerModel> makers = mrepo.findAll();
		
		for(MakerModel makermodel: makers) {
			MakerResponseDto makerresponsedto= new MakerResponseDto();
			makerresponsedto.setId(makermodel.getId());
			makerresponsedto.setNombre(makermodel.getNombre());
			makerresponsedto.setProducts(makermodel.getProducts());
			
			listamakersres.add(makerresponsedto);
			
		}
		
		
		

		return listamakersres;
	}
	
	
	
	public MakerResponseDto findByName(String nombre) {
		
		//Dto respuesta
		MakerResponseDto makerresponsedto= new MakerResponseDto();
		
		//Se busca en el repositorio
		Optional<MakerModel> opmaker = mrepo.findByNombre(nombre);
		if(!opmaker.isPresent())
			throw new MakerNotFoundExeption(" No se encontro el maker:"+" "+nombre);
		
		
		return this.createMaker(opmaker);
		
	}
	
	
	
	public MakerResponseDto findById(Integer id) {
		
		//Dto respuesta
		MakerResponseDto makerresponsedto= new MakerResponseDto();
		
		Optional<MakerModel> opmaker=mrepo.findById(id);
		if(!opmaker.isPresent())
			throw new MakerNotFoundExeption("No se encontro el maker con el id :"+id);
		
		
		return this.createMaker(opmaker);
		
	}
	
	
	public MakerResponseDto saveMaker(MakerModel maker) {
		//Dto respuesta
		MakerResponseDto makerresponsedto= new MakerResponseDto();
		
		//Se busca en el repositorio
		Optional<MakerModel> opmaker = mrepo.findByNombre(maker.getNombre());
		
		if( opmaker.isPresent()) {
			
			throw new MakerDuplicateException("Ya existe un maker con el nombre :"+ maker.getNombre());
		}
		
		
		
		MakerModel savedmaker = mrepo.save(maker);
		
		makerresponsedto.setId(savedmaker.getId());
		makerresponsedto.setNombre(savedmaker.getNombre());
		
		
		
		return makerresponsedto;
		
	}
	
	
	
	public MakerResponseDto createMaker(Optional<MakerModel> opmaker) {
		
		//Dto respuesta
		MakerResponseDto makerresponsedto= new MakerResponseDto();
		
		
		makerresponsedto.setId(opmaker.get().getId());
		makerresponsedto.setNombre(opmaker.get().getNombre());
		makerresponsedto.setProducts(opmaker.get().getProducts());
		
		return makerresponsedto;
		
		
	}



	
	
	

}
