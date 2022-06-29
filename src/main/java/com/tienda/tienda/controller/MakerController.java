package com.tienda.tienda.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tienda.dto.response.MakerResponseDataDto;
import com.tienda.dto.response.MakerResponseDto;
import com.tienda.tienda.model.MakerModel;
import com.tienda.tienda.service.IMakerService;
import com.tienda.tienda.service.MakerRepository;
import com.tienda.tienda.services.exeptions.MakerNotFoundExeption;


@RestController
public class MakerController {
	
	
	private MakerRepository mrepo;
	
	
	
	@Autowired
	private IMakerService makerservice;
	
	
	//GET ALL MAKERS
	@GetMapping("/makers")
	public ResponseEntity<?>findAll(){
		
		//Dto respuesta
		MakerResponseDataDto makerresponsedata= new MakerResponseDataDto();
		
		//Lista respuesta del servicio
		List<MakerResponseDto> listamakersresponse = makerservice.findAll();
		
		
		//Se setean datos 
		makerresponsedata.setData(listamakersresponse);
		
	
		return new ResponseEntity<>(makerresponsedata ,HttpStatus.OK);
	
	}
	
	
	//FIND MAKER BY NAME
	@GetMapping("/makers/name")
	public ResponseEntity<?> findByName(@RequestParam(name = "nombre", required = true) String nombre){
		
		MakerResponseDto makerresponsedto = makerservice.findByName(nombre);
		
		return new ResponseEntity<>(makerresponsedto,HttpStatus.OK);
				
	}
		
	
	
	// GET A SINGLE MAKER
	@GetMapping("/makers/id")
	public ResponseEntity<?>  retrievemaker(@RequestParam (name="id", required = true) Integer id) {
		
		MakerResponseDto makerresponsedto = makerservice.findById(id);
		
		return new ResponseEntity<>(makerresponsedto,HttpStatus.OK);
		
		
	}
	
	//POST A MAKER
	
	
	@PostMapping("/makers")
	public ResponseEntity<Object> createpost(@RequestBody MakerModel maker) {
		
		MakerResponseDto makerresponsedto = makerservice.saveMaker(maker);
		
		return new ResponseEntity<>(makerresponsedto,HttpStatus.OK);
		
		
		
			
	}//Fin metodo
	
	

}//Fin controlador
