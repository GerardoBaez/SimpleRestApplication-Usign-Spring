package com.tienda.tienda.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tienda.entities.Maker;


public interface MakerRepository extends JpaRepository<Maker,Integer> {
	
	public Optional<Maker> findByNombre(String nombre);



}
