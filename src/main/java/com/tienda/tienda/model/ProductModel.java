package com.tienda.tienda.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase ProductModel
 * que representa a un producto
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
public class ProductModel implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty(message = "El nombre del producto no puede estar vacio")
	private String nombre;
	
	@DecimalMin("0.00")
	@NotNull(message="El precio no puede ser null")
	private Double precio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@Autowired
	private MakerModel maker;
	
	
	
	/**
	//RETRIEVE ONLY THE NAME OF THE MAKER
	public String getMaker() {
		String nombre=maker.getNombre();
		return nombre;
	}
	**/


	@Override
	public String toString() {
		return "Product [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}






	
	//private fabricante codigoFabricante;

}
