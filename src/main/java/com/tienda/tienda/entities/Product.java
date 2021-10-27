package com.tienda.tienda.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty(message = "El nombre del producto no puede estar vacio")
	private String nombre;
	
	@DecimalMin("0.00")
	@NotNull(message="El precio no puede ser null")
	private Double precio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Maker maker;
	
	
	

	/*
	public Maker getMaker() {
		return maker;
	}
	*/
	
	
	
	
	


	
	//RETRIEVE ONLY THE NAME OF THE MAKER
	public String getMaker() {
		String nombre=maker.getNombre();
		return nombre;
	}
	


	@Override
	public String toString() {
		return "Product [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}







	public Product() {
		super();
	
	}
	
	
	public Product(Integer id, String nombre, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	

	
	//private fabricante codigoFabricante;

}
