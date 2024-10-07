package com.game.service_api.commons.entities;

import java.io.Serializable;
import java.util.Optional;

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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

	@Column(name = "name", updatable = true, nullable = false, unique = false, length = 150)
    private String name;
	
	@Column(name = "estatus", updatable = true, nullable = false, unique = false)
    private Boolean estatus;

	public static Game convertirToEntity(Optional<Game> game) {
		Game gameResponse = new Game();
		gameResponse.setId(game.get().getId());
		gameResponse.setName(game.get().getName());
		gameResponse.setEstatus(game.get().getEstatus());
		return gameResponse;
	}
	
}
