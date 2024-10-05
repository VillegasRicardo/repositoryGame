package com.game.service_api.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.game.service_api.Model.GameModel;
import com.game.service_api.entity.Game;
import com.game.service_api.repository.GameRepository;

/**
 * Fachada para gestionar las operaciones relacionadas con los juegos.
 */
@Component
public class GameFacade{

	private final GameRepository gameRepository;
	
    /**
     * Constructor de la fachada que inyecta el repositorio de juegos.
     * @param repository el repositorio de juegos
     */
	public GameFacade(GameRepository repository) {
		this.gameRepository = repository;
	}
	
    /**
     * Guarda un nuevo juego.
     * @param game el juego a guardar
     * @return la entidad del juego guardado
     */
    public GameModel saveGame(Game gameRequest) {   	
    	GameModel gameModel = GameModel.convertirToModel(gameRepository.save(gameRequest));  	
		return gameModel;
	}
	
    /**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
    public List<Game> searchAll() {		
    	List<Game> gameShearchAll = this.gameRepository.findAll();		
		return gameShearchAll;
	}
    
    /**
     * Obtiene una lista de juegos por el nombre.
     * @param nameRequest el nombre del juego
     * @return una lista de juegos que coinciden con el nombre
     */
    public List<Game> searchByName(String nameRequest) {		
    	List<Game> gameSearchByName = this.gameRepository.findByName(nameRequest);		
		return gameSearchByName;
	}
    
    /**
     * Obtiene un juego por su ID.
     * @param idRequest el ID del juego
     * @return el modelo del juego que coincide con el ID
     * @throws RuntimeException si no se encuentra ningún juego con el ID proporcionado
     */
    public GameModel searchById(Long idRequest) {
        return this.gameRepository.findById(idRequest)
            .map(game -> {
                GameModel gameModelResponse = new GameModel();
                gameModelResponse.setId(game.getId());
                gameModelResponse.setName(game.getName());
                gameModelResponse.setEstatus(game.getEstatus());
                return gameModelResponse;
            })
            .orElseThrow(() -> new RuntimeException("No se encontró ningún resultado con el valor de entrada."));
    }
}
