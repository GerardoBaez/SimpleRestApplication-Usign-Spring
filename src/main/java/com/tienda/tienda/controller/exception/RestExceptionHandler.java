package com.tienda.tienda.controller.exception;



import javax.servlet.http.HttpServletRequest;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.tienda.controller.exception.model.DefaultError;
import com.tienda.controller.exception.model.DefaultErrorList;
import com.tienda.exception.catalog.GeneralCatalog;





/**
 * Esta clase se encarga de servir como apoyo al controller, manejando de manera desacoplada 
 * las excepciones esperadas en la aplicacion, y manejando el catalogo de errores con ayuda de un enumerador personalizado.
 * Tambien tiene un manejo de errores genericos.
 */
@ControllerAdvice
public class RestExceptionHandler {

	//La Constante LOGGER. Obtiene el Logger de la clase 
	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	
	/**
     * Manejo de excepciones de validacion de formatos de numeros de entrada
     * @param pe Excepcion de tipo NumberFormatException
     * @param request Informacion del request enviado
     * @return ResponseEntity<DefaultErrorList> La entidad de respuesta que maneja el error como objeto
     */
	@ExceptionHandler(value = {NumberFormatException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionB(NumberFormatException pe, HttpServletRequest request) {
    	LOGGER.warn("Excepcion de formatos de numeros de entrada, {}", pe.getMessage());
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(GeneralCatalog.GRAL002.getCode(),
																						GeneralCatalog.GRAL002.getMessage(),
																						GeneralCatalog.GRAL002.getLevelException().toString(),
																						"Excepcion de formatos de numeros de entrada",
																						request.getRequestURL().toString()
																						)), GeneralCatalog.GRAL002.getHtttpStatus());
	}//Fin del metodo 

	/**
     * Manejo de excepciones de validacion de tipo de datos de entrada
     * @param pe Excepcion de tipo MethodArgumentTypeMismatchException
     * @param request Informacion del request enviado
     * @return ResponseEntity<DefaultErrorList> La entidad de respuesta que maneja el error como objeto
     */
	@ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionC(MethodArgumentTypeMismatchException pe, HttpServletRequest request) {
    	LOGGER.warn("Excepcion de tipo de datos de entrada, {}", pe.getMessage());
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(GeneralCatalog.GRAL002.getCode(),
																							GeneralCatalog.GRAL002.getMessage(),
																							GeneralCatalog.GRAL002.getLevelException().toString(),
																							"Excepcion de tipo de datos de entrada",
																							request.getRequestURL().toString()
																							)), GeneralCatalog.GRAL002.getHtttpStatus());
	}//Fin del metodo 


	/**
     * Manejo de excepciones de validacion de cantidad de parametros de entrada enviados
     * @param pe Excepcion de tipo MissingServletRequestParameterException
     * @param request Informacion del request enviado
     * @return ResponseEntity<DefaultErrorList> La entidad de respuesta que maneja el error como objeto
     */
	@ExceptionHandler(value = {MissingServletRequestParameterException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionD(MissingServletRequestParameterException pe, HttpServletRequest request) {
    	LOGGER.warn("Excepcion de cantidad de parametros de entrada enviados, {}", pe.getMessage());
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError(GeneralCatalog.GRAL002.getCode(),
																							GeneralCatalog.GRAL002.getMessage(),
																							GeneralCatalog.GRAL002.getLevelException().toString(),
																							"Excepcion de cantidad de parametros de entrada enviados",
																							request.getRequestURL().toString()
																							)), GeneralCatalog.GRAL002.getHtttpStatus());
	}//Fin del metodo
	

    
	
	/**
	 * Manejo de excepcion metodo HTTP no soportado
	 * @param ex Excepcion generica de tipo Exception
	 * @param request Informacion del request enviado
	 * @return ResponseEntity<DefaultErrorList> La entidad de respuesta que maneja el error como objeto
	 */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<DefaultErrorList> handlerMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
		LOGGER.error("Error metodo HTTP no soportado para este endpoint, {}", Encode.forJava(request.getRequestURL().toString()));
		return new ResponseEntity<DefaultErrorList>(new DefaultErrorList(new DefaultError
																			(GeneralCatalog.GRAL001.getCode(),
																			GeneralCatalog.GRAL001.getMessage(),
																			GeneralCatalog.GRAL001.getLevelException().toString(),
																			"Metodo HTTP no soportado para este endpoint",
																			request.getRequestURL().toString()
																			)), HttpStatus.INTERNAL_SERVER_ERROR);
    }//Fin del metodo 
	
    
	
}//Fin de la clase