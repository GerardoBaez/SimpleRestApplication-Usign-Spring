package com.tienda.tienda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase MakerModel
 * que representa a un proveedor(maker)
 * en la base de datos
 * @author Gerardo
 *
 */


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MakerModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty(message = "El nombre del provedor no puede estar vacio")
	private String nombre;
	
	
	@OneToMany(mappedBy="maker")
	private List<ProductModel>products;
	

	// RETRIEVE ONLY THE NAME OF THE PRODUCT
	public String[] getProducts() {
		String[] myArray = new String [products.size()];
		int i=0;
		for(ProductModel p:products) {
			String nombre=p.getNombre();
			myArray[i]=nombre;
			i++;
		}
		return myArray;
		
	}
	

	
	
	public MakerModel(Integer id, @NotEmpty(message = "El nombre del provedor no puede estar vacio") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Maker [id=" + id + ", nombre=" + nombre + ", products=" + products + "]";
		
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;







	



	


}
