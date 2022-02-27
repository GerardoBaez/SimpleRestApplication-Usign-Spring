package com.tienda.tienda.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tienda.model.MakerModel;


public interface MakerRepository extends JpaRepository<MakerModel,Integer> {
	
	public Optional<MakerModel> findByNombre(String nombre);



}
