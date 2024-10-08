package com.game.service_api.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.game.service_api.commons.entities.Game;
import com.game.service_api.commons.exceptions.GameException;

public interface GameService {
	
	/**
     * Guarda un nuevo juego.
     * @param game el juego a guardar
     * @return la entidad del juego guardado
     */
	Game saveGame(Game gameRequest);
	
	/**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
	List<Game> getGameAll();
	
	/**
	 * Obtiene una lista de juegos por el nombre.
	 * @param nameRequest el nombre del juego
	 * @return una lista de juegos que coinciden con el nombre
	 */
	List<Game> getGameByName(@PathVariable("name")String nameRequest);
	
	/**
     * Obtiene un juego por su ID.
     * @param idRequest el ID del juego
     * @return el modelo del juego que coincide con el ID
     * @throws RuntimeException si no se encuentra ningún juego con el ID proporcionado
     */
	Game getGameById(Long idRequest);
	
	/**
	 * Actualiza el estatus de un juego.
	 * @param id el ID del juego
	 * @param game el modelo del juego con el estatus actualizado
	 * @return el modelo del juego actualizado
	 */
	Game updateStatusGame(@PathVariable("id") Long idRequest, Game gameRequest);
	
	 /**
     * Elimina un juego por su ID.
     * Este método busca un juego por su ID y lo elimina del repositorio. Si el juego no se encuentra,
     * lanza una excepción GameException con un estado HTTP 404 (Not Found).
     * @param idRequest el ID del juego a eliminar
	 * @return 
     * @throws GameException si el juego no se encuentra
     */
	void deleteGame(Long idRequest);
	
}
