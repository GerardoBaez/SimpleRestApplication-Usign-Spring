package com.tienda.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria InvalidData
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author
 */
public enum InvalidDataCatalog {
	//INVD001
	INVD001("InvalidDataException001","INVD.001","Error al mapear datos.",HttpStatus.CONFLICT,LevelException.ERROR),
	//INVD002
	INVD002("InvalidDataException002","INVD.002","Error al codificar archivo.",HttpStatus.CONFLICT,LevelException.ERROR);
	//La variable type
	private final String typpe;
	//La variable code
	private final String codde;
	//La variable message 
	private final String messsage;
	//La variable htttpStatus
	private final HttpStatus htttppStatus;
	//La variable levelException
	private final LevelException levvelException;
	
	/**
	 * Constructor InvalidDataCatalog
	 * @param type tipo
	 * @param code codigo 
	 * @param message mensaje 
	 * @param htttpStatus estado del http 
	 * @param levelException levelExcepcion 
	 */
	InvalidDataCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.typpe = type;
		this.codde = code;
		this.messsage = message;
		this.htttppStatus = htttpStatus;
		this.levvelException = levelException;
	}//Fin del constructor 

	/**
	 * Obtener valor de la variable tipo (type)
	 * @return String type 
	 */
	public String getType() {
		return typpe;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable codigo (code)
	 * @return String code
	 */
	public String getCode() {
		return codde;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable mensaje (message)
	 * @return String message
	 */
	public String getMessage() {
		return messsage;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable del estado del http (htttpStatus)
	 * @return HttpStatus htttpStatus
	 */
	public HttpStatus getHtttpStatus() {
		return htttppStatus;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable level excepcion (levelException)
	 * @return LevelException levelException
	 */
	public LevelException getLevelException() {
		return levvelException;
	}//Fin del metodo 
}//Fin del ENUM
