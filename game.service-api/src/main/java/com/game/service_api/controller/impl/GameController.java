package com.game.service_api.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.service_api.commons.entities.Game;
import com.game.service_api.controller.GameApi;
import com.game.service_api.service.GameService;

/**
 * Controlador REST para gestionar las operaciones relacionadas con los juegos.
 */
@RestController
public class GameController implements GameApi{

    private final GameService gameService;

    /**
     * Constructor del controlador que inyecta el servicio de juegos.
     * @param gameService el servicio de juegos
     */
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    /**
     * Guarda un nuevo juego.
     * @param game el juego a guardar
     * @return la entidad del juego guardado
     */
    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
    	Game gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }
   
    /**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
    @Override
    public List<Game> getGameAll() {
        return gameService.getGameAll();
    }

    /**
     * Obtiene una lista de juegos por el nombre.
     * @param name el nombre del juego
     * @return una lista de juegos que coinciden con el nombre
     */
    @Override
    public List<Game> getGameByName(@PathVariable String name) {
        return gameService.getGameByName(name);
    }

    /**
     * Obtiene un juego por su ID.
     * @param id el ID del juego
     * @return el modelo del juego que coincide con el ID
     */
    @Override
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
    	Game gameFound = gameService.getGameById(id);
    	return ResponseEntity.ok(gameFound);
    }
  
    /**
     * Actualiza el estatus de un juego.
     * @param id el ID del juego
     * @param statusUpdateDTO el DTO que contiene el nuevo estatus
     * @return la entidad del juego actualizado
     */
    @Override
    public ResponseEntity<Game> updateStatus(@PathVariable Long id, @RequestBody Game game) {
    	Game gameUpdateStatus = gameService.updateStatusGame(id,game);
    	return ResponseEntity.ok(gameUpdateStatus);
    } 
      
}
