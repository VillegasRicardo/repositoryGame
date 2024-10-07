package com.game.service_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.game.service_api.commons.entities.Game;

/**
 * Repositorio JPA para gestionar las operaciones CRUD relacionadas con la entidad Game.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	/**
     * Encuentra todos los juegos.
     * @return una lista de todos los juegos
     */
	List<Game> findAll();
	
	/**
     * Encuentra una lista de juegos por su nombre.
     * @param name el nombre del juego
     * @return una lista de juegos que coinciden con el nombre proporcionado
     */
	List<Game> findByName(String name);
	
	/**
	 * Encuentra un juego por su ID.
	 * @param id el ID del juego
	 * @return el juego que coincide con el ID proporcionado
	 */
	Optional<Game> findById(Long id);
	
}
