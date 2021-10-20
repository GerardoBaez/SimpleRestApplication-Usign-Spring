package com.tienda.tienda.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tienda.entities.Maker;
import com.tienda.tienda.entities.Product;

public interface MakerRepository extends JpaRepository<Maker,Integer> {

}
