package com.game.service_api.commons.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Clase GameException que representa una excepción específica para el contexto de un juego.
 * 
 * Esta excepción se utiliza para manejar errores específicos que pueden ocurrir durante
 * la ejecución de la lógica del juego.
 * 
 * Métodos incluidos:
 * - getHttpsStatus: Devuelve el estado HTTP asociado con esta excepción.
 * - getMessage: Devuelve el mensaje descriptivo del error.
 */
@Getter
public class GameException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpsStatus;
	
	/**
     * Constructor de la clase GameException.
     * 
     * @param message El mensaje descriptivo del error.
     * @param httpsStatus El estado HTTP asociado con esta excepción.
     */
	public GameException(HttpStatus httpsStatus, String message) {
		super(message);
		this.httpsStatus = httpsStatus;		
	}
	
	
	
	
}
