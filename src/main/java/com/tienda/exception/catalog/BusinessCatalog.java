package com.tienda.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria Business
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author
 */
public enum BusinessCatalog {
	//BUSI001
	BUSI001("BusinessException001","BUSI.001","Error el documento no puede exceder el minimo y maximo de tamaño.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//BUSI002
	BUSI002("BusinessException002","BUSI.002","Formato de archivo no soportado.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//BUSI003
	BUSI003("BusinessException003","BUSI.003","Se ha excedido el limite de archivos.",HttpStatus.BAD_REQUEST,LevelException.WARN);

	//La variable type
	private final String ttype;
	//La variable code
	private final String ccode;
	//La variable message
	private final String mmessage;
	//La variable htttpStatus
	private final HttpStatus hhtttpStatus;
	//La variable levelException
	private final LevelException llevelException;
	
	/**
	 * Constructor BusinessCatalog
	 * @param type tipo
	 * @param code codigo
	 * @param message mensaje 
	 * @param htttpStatus estado del http
	 * @param levelException levellException
	 */
	BusinessCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.ttype = type;
		this.ccode = code;
		this.mmessage = message;
		this.hhtttpStatus = htttpStatus;
		this.llevelException = levelException;
	}//Fin del constructor 

	/**
	 * Obtiene valor de la variable tipo
	 * @return String type
	 */
	public String getType() {
		return ttype;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable codigo 
	 * @return String code
	 */
	public String getCode() {
		return ccode;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable mensaje 
	 * @return String message
	 */
	public String getMessage() {
		return mmessage;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable estado del http
	 * @return HttpStatus 
	 */
	public HttpStatus getHtttpStatus() {
		return hhtttpStatus;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable levelException
	 * @return LevelException
	 */
	public LevelException getLevelException() {
		return llevelException;
	}//Fin del metodo 
}//Fin del ENUM
