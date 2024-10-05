package com.game.service_api.entity;

import java.io.Serializable;

import com.game.service_api.Model.GameModel;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad que representa un juego en la base de datos.
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "games", indexes = @Index(name = "games_id_idx", columnList = "id"))
public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Campo para el Identificador del juego")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

	@ApiModelProperty(value = "Campo para el nombre del juego")
	@Column(name = "name", updatable = true, nullable = false, unique = false, length = 150)
    private String name;
	
	@ApiModelProperty(value = "Campo para el estatus del juego")
	@Column(name = "estatus", updatable = true, nullable = false, unique = false)
    private Boolean estatus;

	public static Game convertirToEntity(GameModel gameModel) {
		Game game = new Game();
		game.setId(gameModel.getId());
		game.setName(gameModel.getName());
		game.setEstatus(gameModel.getEstatus());
		return game;
	}
	
}
