package com.game.service_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.service_api.Model.GameModel;
import com.game.service_api.entity.Game;
import com.game.service_api.facade.GameFacade;

/**
 * Servicio para gestionar las operaciones relacionadas con los juegos.
 */
@Service
public class GameService {
	
	private final GameFacade gameFacade;

	/**
	 * Constructor del servicio que inyecta la fachada de juegos.
	 * @param gameFacade la fachada de juegos
	 */
    public GameService(GameFacade gameFacade) {
    	this.gameFacade = gameFacade; 
    }
	
	/**
     * Guarda un nuevo juego.
     * @param game el juego a guardar
     * @return la entidad del juego guardado
     */
	public GameModel saveGame(Game gameRequest) {		
		return this.gameFacade.saveGame(gameRequest);
	}
	
 	/**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
	public List<Game> searchAll (){
		return gameFacade.searchAll();
	}
	

	/**
	 * Obtiene una lista de juegos por el nombre.
	 * @param nameRequest el nombre del juego
	 * @return una lista de juegos que coinciden con el nombre
	 */
	public List<Game> searchByName(String nameRequest) {		
    	List<Game> gameShearchAll = this.gameFacade.searchByName(nameRequest);		
		return gameShearchAll;
	}
	
	/**
     * Obtiene un juego por su ID.
     * @param id el ID del juego
     * @return el modelo del juego que coincide con el ID
     * @throws RuntimeException si no se encuentra ningún juego con el ID proporcionado
     */
	public GameModel searchById(Long idRequest) {		
		GameModel gamSearchById = this.gameFacade.searchById(idRequest);		
		return gamSearchById;
	}

	/**
	 * Actualiza el estatus de un juego.
	 * @param id el ID del juego
	 * @param gameModel el modelo del juego con el estatus actualizado
	 * @return el modelo del juego actualizado
	 */
	public GameModel updateStatusGame(Long id, GameModel gameModel) {
		Game game = Game.convertirToEntity(gameFacade.searchById(id)); 
		game.setEstatus(gameModel.getEstatus());
		 return gameFacade.saveGame(game);
	}
	
	
}
