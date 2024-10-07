package com.game.service_api.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase ErrorResponse que representa una respuesta de error.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private Integer codeStatus;
	private String message;
}
