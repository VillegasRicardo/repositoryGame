package com.game.service_api.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.game.service_api.commons.entities.Game;
import com.game.service_api.commons.exceptions.GameException;
import com.game.service_api.repository.GameRepository;
import com.game.service_api.service.GameService;

/**
 * Servicio para gestionar las operaciones relacionadas con los juegos.
 */
@Service
public class GameServiceImpl implements GameService {
	
	private final GameRepository gameRepository;

	/**
	 * Constructor del servicio que inyecta la fachada de juegos.
	 * @param gameFacade la fachada de juegos
	 */
    public GameServiceImpl(GameRepository gameRepository) {
    	this.gameRepository = gameRepository; 
    }
	
	/**
     * Guarda un nuevo juego.
     * @param game el juego a guardar
     * @return la entidad del juego guardado
     */
    @Override
	public Game saveGame(Game gameRequest) {
		Game gameCreatedInDataBase = this.gameRepository.save(gameRequest);
		return gameCreatedInDataBase;
	}
	
	/**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
    @Override
	public List<Game> getGameAll (){
		return gameRepository.findAll();
	}
	
	/**
	 * Obtiene una lista de juegos por el nombre.
	 * @param nameRequest el nombre del juego
	 * @return una lista de juegos que coinciden con el nombre
	 */
    @Override
	public List<Game> getGameByName(String nameRequest) {		
    	List<Game> gameShearchAll = this.gameRepository.findByName(nameRequest);		
		return gameShearchAll;
	}
	
	/**
     * Obtiene un juego por su ID.
     * @param id el ID del juego
     * @return el modelo del juego que coincide con el ID
     * @throws RuntimeException si no se encuentra ningún juego con el ID proporcionado
     */
    @Override
	public Game getGameById(Long idRequest) {		
		return this.gameRepository.findById(idRequest)
	            .map(game -> {
	                Game gameResponse = new Game();
	                gameResponse.setId(game.getId());
	                gameResponse.setName(game.getName());
	                gameResponse.setEstatus(game.getEstatus());
	                return gameResponse;
	            })
	            .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"No se encontró ningún resultado con el valor de entrada."));
	}

	/**
	 * Actualiza el estatus de un juego.
	 * @param id el ID del juego
	 * @param gameModel el modelo del juego con el estatus actualizado
	 * @return el modelo del juego actualizado
	 */
    @Override
	public Game updateStatusGame(Long id, Game gameRequest) {
		Game game = Game.convertirToEntity(gameRepository.findById(id)); 
		game.setEstatus(gameRequest.getEstatus());
		 return gameRepository.save(game);
	}
		
}
