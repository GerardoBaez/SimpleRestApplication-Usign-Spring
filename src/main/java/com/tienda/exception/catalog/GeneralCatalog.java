package com.tienda.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria General
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author 
 */
public enum GeneralCatalog {
	//GRAL001
	GRAL001("GeneralException001","GRAL.001","Error generico de servidor.",HttpStatus.INTERNAL_SERVER_ERROR,LevelException.ERROR),
	//GRAL002
	GRAL002("GeneralException002","GRAL.002","Error al enviar Query Parameters.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//GRAL003
	GRAL003("GeneralException003","GRAL.003","URI parameters no valido.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//GRAL004
	GRAL004("GeneralException004","GRAL.004","Conflicto al realizar la operación.",HttpStatus.CONFLICT,LevelException.ERROR),
	//GRAL005
	GRAL005("GeneralException005","GRAL.005","Consulta duplicada.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//GRAL006
	GRAL006("GeneralException006","GRAL.006","Error al enviar parametros.",HttpStatus.BAD_REQUEST,LevelException.WARN)	;
	//La variable type
	private final String tyype;
	//La variable code
	private final String coode;
	//La variable message
	private final String meessage;
	//La variable httpStatus
	private final HttpStatus httttpStatus;
	//La variable levelException
	private final LevelException leevelException;
	
	/**
	 * Constructor GeneralCatalog
	 * @param type tipo
	 * @param code codigo
	 * @param message mensaje 
	 * @param htttpStatus estado del http
	 * @param levelException levellExcepcion 
	 */
	GeneralCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.tyype = type;
		this.coode = code;
		this.meessage = message;
		this.httttpStatus = htttpStatus;
		this.leevelException = levelException;
	}//Fin del constructor 
	
	/**
	 * Obtiene valor de la variable de tipo(type)
	 * @return String type
	 */
	public String getType() {
		return tyype;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable de codigo (code)
	 * @return String code
	 */
	public String getCode() {
		return coode;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable de mensaje (message)
	 * @return String message
	 */
	public String getMessage() {
		return meessage;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable del estado del http
	 * @return HttpStatus htttpStatus
	 */
	public HttpStatus getHtttpStatus() {
		return httttpStatus;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable levelException
	 * @return LevelException levelException
	 */
	public LevelException getLevelException() {
		return leevelException;
	}//Fin del metodo 
}//Fin del ENUM
