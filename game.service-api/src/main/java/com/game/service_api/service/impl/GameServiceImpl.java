package com.game.service_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.game.service_api.commons.constants.Constantes;
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
		return this.gameRepository.findAll();
	}
	
	/**
	 * Obtiene una lista de juegos por el nombre.
	 * @param nameRequest el nombre del juego
	 * @return una lista de juegos que coinciden con el nombre
	 */
    @Override
	public List<Game> getGameByName(String nameRequest) {		
    	List<Game> gameShearchAll = this.gameRepository.findAllByName(nameRequest);		
		return gameShearchAll;
	}
	
	/**
     * Obtiene un juego por su ID.
     * @param idRequest el ID del juego
     * @return el modelo del juego que coincide con el ID
     * @throws RuntimeException si no se encuentra ningún juego con el ID proporcionado
     */
    @Override
	public Game getGameById(Long idRequest) {		
		return this.gameRepository.findAllById(idRequest)
	            .map(game -> {
	                Game gameResponse = new Game();
	                gameResponse.setId(game.getId());
	                gameResponse.setName(game.getName());
	                gameResponse.setEstatus(game.getEstatus());
	                return gameResponse;
	            })
	            .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, Constantes.NO_SE_ENCONTRO_RESULTADO));
	}

	/**
	 * Actualiza el estatus de un juego.
	 * @param id el ID del juego
	 * @param game el modelo del juego con el estatus actualizado
	 * @return el modelo del juego actualizado
	 */
    @Override
	public Game updateStatusGame(Long id, Game gameRequest) {
		return Optional.of(gameRequest)
				.map(game -> {
					game.setId(id);
				 return this.gameRepository.save(game);	
				})
				.orElseThrow(() -> new GameException(HttpStatus.BAD_REQUEST, Constantes.NO_SE_ACTUALIZO_REGISTRO));
	}
	
    /**
     * Elimina un juego por su ID.
     * 
     * Este método busca un juego por su ID y lo elimina del repositorio. Si el juego no se encuentra,
     * lanza una excepción GameException con un estado HTTP 404 (Not Found).
     * 
     * @param idRequest el ID del juego a eliminar
     * @throws GameException si el juego no se encuentra
     */
    @Override
    public void deleteGame(Long idRequest) {
    	this.gameRepository.findAllById(idRequest).orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, Constantes.NO_SE_ENCONTRO_RESULTADO));
    	this.gameRepository.deleteById(idRequest);
    	
    }
      
}
