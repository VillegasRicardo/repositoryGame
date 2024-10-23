package com.game.service_api.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.service_api.commons.constants.Constantes;
import com.game.service_api.commons.entities.Game;
import com.game.service_api.commons.exceptions.GameException;
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
    public ResponseEntity<Game> saveGame(String id, @RequestBody Game game) {
    	
        return ResponseEntity.ok(this.gameService.saveGame(game));
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
    public List<Game> getGameByName(@PathVariable("name") String nameRequest) {
        return gameService.getGameByName(nameRequest);
    }

    /**
     * Obtiene un juego por su ID.
     * @param idRequest el ID del juego
     * @return el modelo del juego que coincide con el ID
     */
    @Override
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long idRequest) { 
    	return ResponseEntity.ok(gameService.getGameById(idRequest));
    }
  
    /**
     * Actualiza el estatus de un juego.
     * @param idRequest el ID del juego
     * @param statusUpdateDTO el DTO que contiene el nuevo estatus
     * @return la entidad del juego actualizado
     */
    @Override
    public ResponseEntity<Game> updateStatus(@PathVariable("id") Long idRequest, @RequestBody Game gameRequest) {
    	return ResponseEntity.ok(gameService.updateStatusGame(idRequest, gameRequest));
    } 
      
    /**
     * Elimina un juego por su ID.
     * Este método busca un juego por su ID y lo elimina del repositorio. Si el juego no se encuentra,
     * lanza una excepción GameException con un estado HTTP 404 (Not Found).
     * @param idRequest el ID del juego a eliminar
     * @throws GameException si el juego no se encuentra
     */
    @Override
    public ResponseEntity<String> deleteGame(@PathVariable("id") Long idRequest) {
        gameService.deleteGame(idRequest);
        return ResponseEntity.status(HttpStatus.OK).body(Constantes.REGISTRO_ELIMINADO_CORRECTAMENTE);
    }
    
}
