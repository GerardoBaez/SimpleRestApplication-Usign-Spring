package com.tienda.controller.exception.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * (Arquetipo creado por Santander Tecnologia Mexico)
 * La clase DefaultErrorResponseBean, usada para enviar la respuesta en caso de error durante la ejecucion del servicio. 
 * @author David Gonzalez 
 * 
 * 
 */
public class DefaultErrorList implements Serializable {

	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;

	//La variable errors
	private List<DefaultError> errors;
	
	/** 
	 * Constructor de la clase.
	 * Un ejemplo de implementacion es agregar la siguiente linea: DefaultErrorResponseBean errorResp = new DefaultErrorResponseBean(new ErrorBean(ErrorEnum.FORBIDDEN)); En donde el objeto ErrorEnum es la clase con la serie de codigos de errores (Puede utilizarse esa misma clase generica, o una implementacion propia)
	 * @param errorBean Bean de errores
	 */
	public DefaultErrorList(final DefaultError errorBean){
		errors = new ArrayList<>();
		errors.add(errorBean);
	}//Fin del constructor

	/**
	 * Obtiene el valor de la variable errors.
	 * @return List<DefaultError> el errors
	 */
	public List<DefaultError> getErrors() {
		return new ArrayList<>(errors);
	}//Fin del metodo

	/**
	 * Coloca el valor de errors.
	 * @param errors es el nuevo valor de errors
	 */
	public void setErrors(List<DefaultError> errors) {
		this.errors = new ArrayList<>(errors);
	}//Fin del metodo
	
	/**
	 * @return String El json en string del objeto completo
	 * @throws JsonProcessingException Cuando existe error en el parseo
	 */
	public String toJsonString() throws JsonProcessingException{
		ObjectMapper objectMapper= new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}//Fin del metodo
}//Fin de la clase
