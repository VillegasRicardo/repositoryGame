package com.game.service_api.Model;

import com.game.service_api.entity.Game;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Modelo de datos para representar un juego.
 */
@Getter
@Setter
@NoArgsConstructor
public class GameModel {

	@ApiModelProperty(value = "Campo para el Identificador del juego")
	private Long id;
	
	@ApiModelProperty(value = "Campo para el nombre del juego")	
	private String name;
	
	@ApiModelProperty(value = "Campo para el estatus del juego")
	private Boolean estatus;
	
	public static GameModel convertirToModel(Game game) {
		GameModel gameModel = new GameModel();
		gameModel.setId(game.getId());
		gameModel.setName(game.getName());
		gameModel.setEstatus(game.getEstatus());
		return gameModel;
	}
	
	
}
