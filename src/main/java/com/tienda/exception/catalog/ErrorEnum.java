package com.tienda.exception.catalog;


/**
 * (Arquetipo creado por Santander Tecnologia Mexico)
 * The Enum ErrorEnum.
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible
 * @author David Gonzalez
 */
public enum ErrorEnum {
	//EXC_GENERICO
	EXC_GENERICO("EXC.000", "Error generico", "Error generico de servidor", LevelException.ERROR.toString(), ""),
	//EXC_ERROR_PARAMS
	EXC_ERROR_PARAMS("EXC.001", "Parametros invalidos", "Parametros invalidos de consumo", LevelException.WARN.toString(), ""),
	//EXC_DUPLICADO
	EXC_DUPLICADO("EXC.100", "Consulta duplicado", "Consulta ya existe, no puede ser sobrescrita", LevelException.WARN.toString(), ""),
	//EXC_OPER_CON_ERRORES
	EXC_OPER_CON_ERRORES("EXC.103", "Operacion con errores", "Operacion con errores", LevelException.ERROR.toString(), "");
	//La variable code
    private final String code;
    //La variable message
    private final String message;
    //La variable description
	private final String description;
	//La variable level 
    private final String level;
    //La variable moreInfo
    private final String moreInfo;
    /**
     * Construtor ErrorEnum
     * @param code codigo 
     * @param message mensaje 
     * @param description descripcion 
     * @param level nivel
     * @param moreInfo mas informacion 
     */
    ErrorEnum(final String code, final String message, 
    		final String description, final String level, final String moreInfo ) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.level = level;
        this.moreInfo = moreInfo;
    }//Fin del constructor 


    /**
     * Obtiene el valor de la variable codigo (code) 
     * @return String code
     */
	public String getCode() {
		return code;
	}//Fin del metodo 


	/**
	 * Obtiene el valor de la variable mensaje (message) 
	 * @return String message
	 */
	public String getMessage() {
		return message;
	}//Fin del metodo 

	/**
	 * Obtiene el valor de la vatiable descripcion (description)
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}//Fin del metodo 

	/**
	 * Obtiene el valor de la variable level 
	 * @return String level
	 */
	public String getLevel() {
		return level;
	}//Fin del metodo 

	/**
	 * Obtiene el valor de la variable de mas información (moreInfo)
	 * @return String moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}//Find del metodo 
}//Fin del ENUM
