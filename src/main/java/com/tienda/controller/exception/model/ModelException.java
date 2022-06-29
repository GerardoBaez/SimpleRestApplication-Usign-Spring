package com.tienda.controller.exception.model;

import org.springframework.http.HttpStatus;

/**
 * 
 * La clase del prototipo de la exception 
 * @author glenn
 *
 */
public class ModelException extends RuntimeException{

	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	
	//Variable HttpStatus
	private final HttpStatus httpStatus;
	
	//Variable code
	private final String code;
	
	//Variable message
	private final String message;
	
	//Variable level
	private final String level;
	
	//Variable description
	private final String description;
	
	/**
	 * Constructor del error de respuesta
	 * @param httpStatus Estatus HTTP de respuesta del error
	 * @param code Codigo interno del error
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 * @param description Descripcion detallada del error
	 */
	public ModelException(HttpStatus httpStatus, String code, String message, String level, String description) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
	}//Fin del constructor 
	
	/**
	 * Constructor del error de respuesta sin descripcion detallada
	 * @param httpStatus Estatus HTTP de respuesta del error
	 * @param code Codigo interno del error
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 */
	public ModelException(HttpStatus httpStatus, String code, String message, String level) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = null;
	}//Fin del constructor
	
	
	/**
	 * Obtiene el valor de la variable serialversion
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}//Fin del metodo 
	
	/**
	 * Obtiene el valor httpstatus
	 * @return httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}//Fin del metodo 
	
	/**
	 * Obtiene el valor code
	 * @return code
	 */
	public String getCode() {
		return code;
	}//Fin del metodo
	
	
	/**
	 * Obtiene el valor message
	 * @return message
	 */
	@Override
	public String getMessage() {
		return message;
	}//Fin del metodo
	
	/**
	 * Obtiene el valor level
	 * @return level
	 */
	public String getLevel() {
		return level;
	}//Fin del metodo 
	
	/**
	 * Obtiene el valor descripcion
	 * @return description
	 */
	public String getDescription() {
		return description;
	}//Fin del metodo 

}//Fin de la clase
