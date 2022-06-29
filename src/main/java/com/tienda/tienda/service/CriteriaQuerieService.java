package com.tienda.tienda.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tienda.dto.request.ProductRequestDto;
import com.tienda.tienda.model.ProductModel;
@Service
public class CriteriaQuerieService {
	
	
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());
	
	
	
	public Specification<ProductModel> createSpecification(ProductRequestDto reqDto) {
		Specification<ProductModel> specification = new Specification<ProductModel>() {
			
			@Override
			public Predicate toPredicate(Root<ProductModel> root, CriteriaQuery<?> query,	CriteriaBuilder cb) {
				//create a new predicate list
		        List<Predicate> predicates = new ArrayList<>();
		        
		        
		      //Predicados
				Predicate predicate = cb.equal(root.get("nombre"), "Disco duro SATA3 1TB");
				Predicate predicate2 = cb.equal(root.get("precio"),  86.99);
				
				
				
				predicates.add(predicate);
				predicates.add(predicate2);
				//predicates.add(predicate3);
				
		 
		        
		    
		        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		LOGGER.info("Crea especificacion query");
		return specification;
	}

}
