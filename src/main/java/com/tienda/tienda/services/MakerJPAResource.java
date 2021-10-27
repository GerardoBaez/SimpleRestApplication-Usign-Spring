package com.tienda.tienda.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tienda.tienda.entities.Maker;

import com.tienda.tienda.services.exeptions.MakerNotFoundExeption;


@RestController
public class MakerJPAResource {
	
	@Autowired
	private MakerRepository mrepo;
	
	
	//GET ALL MAKERS
	@GetMapping("/makers")
	public List<Maker>retrievemakers(){
		return mrepo.findAll();
			
	}
	
	
	//FIND MAKER BY NAME
		@GetMapping("/makers/find/{nombre}")
		public Maker retrievemakerByName(@PathVariable String nombre){
			Optional<Maker> opmaker = mrepo.findByNombre(nombre);
			if(!opmaker.isPresent())
				throw new MakerNotFoundExeption("nombre:"+" "+nombre);
			
			return opmaker.get();
				
		}
		
	
	
	// GET A SINGLE MAKER
	@GetMapping("/makers/{id}")
	public Maker retrievemaker(@PathVariable Integer id) {
		Optional<Maker> opmaker=mrepo.findById(id);
		if(!opmaker.isPresent())
			throw new MakerNotFoundExeption("id"+id);
		
		return opmaker.get();
		
	}
	
	//POST A MAKER
	
	
	@PostMapping("/makers")
	public ResponseEntity<Object> createpost(@RequestBody Maker maker) {
		Maker savedproduct = mrepo.save(maker);
		URI location= ServletUriComponentsBuilder.
				fromCurrentRequest().path("{id}")
				.buildAndExpand(savedproduct.getId()).toUri();
		return ResponseEntity.created(location).build();
			
		}
	
	

}
