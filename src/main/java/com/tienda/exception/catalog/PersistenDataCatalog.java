package com.tienda.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria Persistent
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author 
 */
public enum PersistenDataCatalog {
	//PSID001
	PSID001("PersistentDataException001","PSID.001","Error al realizar la transaccion.",HttpStatus.CONFLICT,LevelException.ERROR),
	//PSID002
	PSID002("PersistentDataException002","PSID.002","Error de conexion en origen de datos.",HttpStatus.CONFLICT,LevelException.ERROR),
	//PSID003
	PSID003("PersistentDataException003","PSID.003","Recurso no encontrado.",HttpStatus.CONFLICT,LevelException.ERROR);
	
	//La variable type
	private final String type;
	//La variable code 
	private final String code;
	//La variable message
	private final String message;
	//La variable htttpStatus
	private final HttpStatus htttpStatus;
	//La variable levelException
	private final LevelException levelException;
	
	/**
	 * Constructor PersistenDataCatalog
	 * @param type tipo
	 * @param code codigo 
	 * @param message mensaje 
	 * @param htttpStatus htttpStatus
	 * @param levelException levelExcepcion
	 */
	PersistenDataCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.type = type;
		this.code = code;
		this.message = message;
		this.htttpStatus = htttpStatus;
		this.levelException = levelException;
	}//Fin del constructor 
	
	/**
	 * Obtener valor de la variable tipo (type)
	 * @return String type
	 */
	public String getType() {
		return type;
	}//Fin del metodo 
	
	/**
	 * Obtener valor de la variable codigo (code)
	 * @return String code
	 */
	public String getCode() {
		return code;
	}//Fin del metdo
	
	/**
	 * Obtener valor de la variable mensaje (message)
	 * @return String message
	 */
	public String getMessage() {
		return message;
	}//Fin del metodo
	
	/**
	 * Obtener valor de la variable estado de http (htttpStatus)
	 * @return HttpStatus htttpStatus
	 */
	public HttpStatus getHtttpStatus() {
		return htttpStatus;
	}//Fin del metodo
	
	/**
	 * Obtener valor de la variable levelExcepcion (levelException)
	 * @return LevelException levelException
	 */
	public LevelException getLevelException() {
		return levelException;
	}//Fin del metodo 
}//Fin del ENUM
