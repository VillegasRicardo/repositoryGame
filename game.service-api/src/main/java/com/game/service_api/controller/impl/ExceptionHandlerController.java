package com.game.service_api.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.game.service_api.commons.dto.ErrorResponse;
import com.game.service_api.commons.exceptions.GameException;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase ExceptionHandlerController que maneja las excepciones en la aplicación.
 * 
 * Esta clase contiene métodos para capturar y manejar diferentes tipos de excepciones
 * que pueden ocurrir durante la ejecución de la aplicación, proporcionando respuestas
 * adecuadas a los clientes.
 * 
 * Métodos incluidos:
 * - handleNotFoundException: Maneja excepciones de tipo NotFoundException.
 * 
 * Cada método devuelve un objeto ErrorResponse con el código de estado y el mensaje de error
 * correspondiente.
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

	@ExceptionHandler(value = {GameException.class})

	/**
	 * Maneja excepciones de tipo GameException.
	 * 
	 * Este método captura las excepciones de tipo GameException que ocurren en la aplicación,
	 * registra el error y construye una respuesta adecuada para el cliente.
	 * 
	 * @param gameException La excepción que se ha lanzado.
	 * @return Un ResponseEntity que contiene un objeto ErrorResponse con el código de estado
	 *         y el mensaje de error correspondiente.
	 */
	ResponseEntity<ErrorResponse> handleError(GameException gameException){
		log.error("new Exception", gameException);
		var errorResponse = ErrorResponse.builder()
				.codeStatus(gameException.getHttpsStatus().value())
				.message(gameException.getMessage())
				.build();
		return ResponseEntity.status(gameException.getHttpsStatus()).body(errorResponse);
	}
	
}
