package com.tienda.tienda.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity
public class Maker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty(message = "El nombre del provedor no puede estar vacio")
	private String nombre;
	
	
	@OneToMany(mappedBy="maker")
	private List<Product>products;
	
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

	/*
	public List<Product> getProducts() {
		return products;
	}
	*/
	
	
	
	// RETRIEVE ONLY THE NAME OF THE PRODUCT
	public String[] getProducts() {
		String[] myArray = new String [products.size()];
		int i=0;
		for(Product p:products) {
			String nombre=p.getNombre();
			myArray[i]=nombre;
			i++;
		}
		return myArray;
		
	}
	

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public Maker() {
		super();
		
	}


	public Maker(Integer id, @NotEmpty(message = "El nombre del provedor no puede estar vacio") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Maker [id=" + id + ", nombre=" + nombre + ", products=" + products + "]";
	}




}
