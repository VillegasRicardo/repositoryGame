package com.game.service_api.commons.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class GameException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpsStatus;
	
	public GameException(HttpStatus httpsStatus, String message) {
		super(message);
		this.httpsStatus = httpsStatus;		
	}
	
	
	
	
}
