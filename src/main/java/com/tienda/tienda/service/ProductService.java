package com.tienda.tienda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tienda.dto.request.ProductRequestDto;
import com.tienda.dto.response.MakerResponseDto;
import com.tienda.dto.response.ProductResponseDataDto;
import com.tienda.dto.response.ProductResponseDto;
import com.tienda.tienda.model.MakerModel;
import com.tienda.tienda.model.ProductModel;
import com.tienda.tienda.services.exeptions.MakerNotFoundExeption;
import com.tienda.tienda.services.exeptions.ProductDuplicateException;
import com.tienda.tienda.services.exeptions.ProductNotFoundExeption;


@Service
public class ProductService implements IProductService{

	
	@Autowired
	private ProductRepository productrepo;
	
	
	
	@Autowired
	private MakerRepository makerrepo;

	
	/**
	 * variable logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	
	
	@Autowired
	private IMakerService makerservice;
	
	
	
	/**
	 * findall
	 */
	@Override
	public List<ProductResponseDto> findall() {
		//Lista respuesta
		List<ProductResponseDto> data= new ArrayList<>();
		
		
		//Se busca en el repositorio todos los productos
		List<ProductModel> productos = productrepo.findAll();
		
		
		for(ProductModel pmodel: productos ) {
			
			LOGGER.info("Provedor {}", pmodel.getMaker());
			
			ProductResponseDto productresponsedto= new ProductResponseDto();
			
			productresponsedto.setNombre(pmodel.getNombre());
			productresponsedto.setPrecio(pmodel.getPrecio());
			productresponsedto.setMakername(pmodel.getMaker().getNombre());
		
			data.add(productresponsedto);
						
		}
		
		
		
		return data;
	
	}//Fin metodo
	
	
	
	
	/**
	 * findByName
	 */
	public ProductResponseDto findByName(String nombre ) {
		
		//Busca en el repositorio
		Optional<ProductModel>opproduct=productrepo.findByNombre(nombre);
		
		//Si no encuentra el producto lanza excepcion
		 if(!opproduct.isPresent())
			 throw new ProductNotFoundExeption("Producto no encontrado :"+" "+nombre);
		 
		 
		 return this.preparaRespuestaFinal(opproduct.get());
		 
	}
	
	
	/**
	 * finbyId
	 */
	public ProductResponseDto finbyId(Integer id) {
	
		Optional<ProductModel>opproduct=productrepo.findById(id);
		
		if(!opproduct.isPresent())
			 throw new ProductNotFoundExeption("No se encontro un producto con el id:"+id);
		 
		 return this.preparaRespuestaFinal(opproduct.get());
	
	}
	
	
	
	
	/**
	 * saveproduct
	 */
	public ProductResponseDto saveproduct(ProductRequestDto product) {
		LOGGER.info("Metodo saveproduct");
		
		Optional<ProductModel>opproduct=productrepo.findByNombre(product.getNombre());
		
		if(opproduct.isPresent())
			 throw new ProductDuplicateException("El producto :"+product.getNombre()+"ya existe");
		
				
		MakerResponseDto makerresponsedto = makerservice.findByName(product.getNombremaker());
		
		
		//Se crea Maker
		MakerModel makermodel= new MakerModel();
		
		makermodel.setNombre(makerresponsedto.getNombre());
		makermodel.setId(makerresponsedto.getId());
		
		
		
		// Crea Producto
		ProductModel productmodel= new ProductModel();
		
		productmodel.setNombre(product.getNombre());
		productmodel.setPrecio(product.getPrecio());
		productmodel.setMaker(makermodel);
		
		LOGGER.info("Se procede a guardar el producto"+ product.getNombre());
		
		
		ProductModel productsave = productrepo.save(productmodel);
		
		
		return this.preparaRespuestaFinal(productsave);
	}
	
	
	
	/**
	 * deleteproduct
	 */
	
	public void deleteproduct(String nombre) {				
		Optional<ProductModel>opproduct=productrepo.findByNombre(nombre);
				
		if(!opproduct.isPresent())
			 throw new ProductNotFoundExeption("No se encontro un producto con el nombre :"+nombre);
					
		productrepo.deleteById(opproduct.get().getId());
	
	}
	
	
	
	public ResponseEntity<?> changeproduct(ProductRequestDto productrequestdto){
		
	
		if(productrequestdto.getNombremaker()==null) {
			throw new MakerNotFoundExeption(" No se encontro el maker:"+" "+productrequestdto.getNombremaker());
			
		}
		
		//Busca en el repositorio
		Optional<ProductModel> opproduct = this.findProductByNombre(productrequestdto.getNombre());
		
		
		//Dto respuesta 
		 ProductResponseDto productresponsedto= new ProductResponseDto();
		 
		
		// Si no existe llama a guardar 

		if(!opproduct.isPresent()) {
			
			LOGGER.info("No existe el producto {}", productrequestdto.getNombre()+ "se procede a guardarlo");
			
			productresponsedto = this.saveproduct(productrequestdto);
			
			return new ResponseEntity<>(productresponsedto ,HttpStatus.CREATED);
	
		}
					
		LOGGER.info("Ya existe el producto  {} se procede a actualizar detalles", productrequestdto.getNombre());
		
		//Se obtiene Model de producto
		 ProductModel productmodel = opproduct.get();
				
		
		
		//Se Obtiene Makemodel	al que se quiere cambiar	
		Optional<MakerModel> opmaker = this.findMakerByNombre(productrequestdto.getNombremaker());
		
		
		
		//Se cambia nombre, precio, maker
		productmodel.setNombre(productrequestdto.getNombre());
		productmodel.setPrecio(productrequestdto.getPrecio());
		productmodel.setMaker(opmaker.get());
		
		
	
		//Se guardan cambios
		ProductModel savedproduct = productrepo.save(productmodel);
		
	

		
		return new ResponseEntity<>(this.preparaRespuestaFinal(savedproduct),HttpStatus.OK);
		
	}
	
	
	public ProductResponseDto preparaRespuestaFinal(ProductModel productmodel) {
		
		//Dto respuesta 
		 ProductResponseDto productresponsedto= new ProductResponseDto();
		 
		//Se prepara respuesta final
		productresponsedto.setMakername(productmodel.getMaker().getNombre());
		productresponsedto.setNombre(productmodel.getNombre());
		productresponsedto.setPrecio(productmodel.getPrecio());
		
		
		return productresponsedto;
		
	}
	
	
	
	
	
	
	
	
	
	public Optional<ProductModel> findProductByNombre(String nombre){
		
		Optional<ProductModel> opproduct = productrepo.findByNombre(nombre);
		
		return opproduct;
	}
	
	
	
	
	//Encontrar maker por nombre 
	public Optional<MakerModel> findMakerByNombre(String nombre){
		
		Optional<MakerModel> opmaker = makerrepo.findByNombre(nombre);
		
		if(!opmaker.isPresent())
			throw new MakerNotFoundExeption(" No se encontro el maker:"+" "+nombre);
		
		
		return opmaker;
		
		
	}
	
	
	
	
	
	
	

}
