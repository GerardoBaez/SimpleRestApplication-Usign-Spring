package com.tienda.tienda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.tienda.dto.request.ProductRequestDto;
import com.tienda.tienda.model.ProductModel;
import com.tienda.tienda.service.CriteriaQuerieService;
import com.tienda.tienda.service.ProductRepository;

@SpringBootTest(classes = TiendaApplication.class)
class CriteriaQuerieTest {
	
	
	@Autowired
	EntityManager entitymanager;
	
	
	
	@Autowired
	CriteriaQuerieService cqservice;
	
	
	
	@Autowired
	ProductRepository prepo;
	
	
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());
	

	@Test
	void basic_querytest() {
			
		CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
		
		CriteriaQuery<ProductModel> cq = cb.createQuery(ProductModel.class);
		
		
		
		Root<ProductModel> from = cq.from(ProductModel.class);
		
		
		TypedQuery<ProductModel> createQuery = entitymanager.createQuery(cq.select(from));
		
		List<ProductModel> resultList = createQuery.getResultList();
		
		LOGGER.info("TODOS LOS PRODUCTOS--->{}",resultList);
	}
	
	@Test
	void basic_querytest2() {
		LOGGER.info("-----LLAMANDO A CREATE SPECIFICATION--------");
		
		Specification<ProductModel> specification = cqservice.createSpecification(new ProductRequestDto());
		
		LOGGER.info("-----LLAMANDO A REPOSITORY--------");
		
		List results = prepo.findAll(specification);
		
		LOGGER.info("RESULTADOS {}",results);
		
	
	}

}
