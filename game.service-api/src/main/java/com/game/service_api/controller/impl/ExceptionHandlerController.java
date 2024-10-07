package com.game.service_api.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.game.service_api.commons.dto.ErrorResponse;
import com.game.service_api.commons.exceptions.GameException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

	@ExceptionHandler(value = {GameException.class})
	ResponseEntity<ErrorResponse> handleError(GameException gameException){
		log.error("new Exception", gameException);
		var errorResponse = ErrorResponse.builder()
				.codeStatus(gameException.getHttpsStatus().value())
				.message(gameException.getMessage())
				.build();
		return ResponseEntity.status(gameException.getHttpsStatus()).body(errorResponse);
	}
	
}
