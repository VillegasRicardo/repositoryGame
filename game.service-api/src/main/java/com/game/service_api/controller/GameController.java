package com.game.service_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.service_api.Model.GameModel;
import com.game.service_api.entity.Game;
import com.game.service_api.service.GameService;

import io.swagger.annotations.ApiOperation;


/**
 * Controlador REST para gestionar las operaciones relacionadas con los juegos.
 */
@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameService gameService;

    /**
     * Constructor del controlador que inyecta el servicio de juegos.
     * @param gameService el servicio de juegos
     */
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    /**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
    @ApiOperation(value = "Controlador para obtener todos los juegos", notes = "Controlador para obtener todos los juegos")
    @GetMapping
    public List<Game> searchAllGame() {
        return gameService.searchAll();
    }

    /**
     * Obtiene una lista de juegos por el nombre.
     * @param name el nombre del juego
     * @return una lista de juegos que coinciden con el nombre
     */
    @ApiOperation(value = "Controlador para obtener una lista de juegos por el nombre", notes = "Controlador para obtener una lista de juegos por el nombre")
    @GetMapping(value = "/search-name/{name}")
    public List<Game> searchByName(@PathVariable String name) {
        return gameService.searchByName(name);
    }

    /**
     * Obtiene un juego por su ID.
     * @param id el ID del juego
     * @return el modelo del juego que coincide con el ID
     */
    @ApiOperation(value = "Controlador para obtener un juego por el ID", notes = "Controlador para obtener un juego por el ID")
    @GetMapping(value = "/search-id/{id}")
    public GameModel searchById(@PathVariable Long id) {
        return gameService.searchById(id);
    }

    /**
     * Guarda un nuevo juego.
     * @param game el juego a guardar
     * @return la entidad del juego guardado
     */
    @ApiOperation(value = "Controlador para guardar un juego", notes = "Controlador para guardar un juego")
    @PostMapping
    public GameModel saveGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }
    
    /**
     * Actualiza el estatus de un juego.
     * @param id el ID del juego
     * @param statusUpdateDTO el DTO que contiene el nuevo estatus
     * @return la entidad del juego actualizado
     */
    @ApiOperation(value = "Controlador para actualizar el estatus de un juego", notes = "Controlador para actualizar el estatus de un juego")
    @PatchMapping(value = "/update-status/{id}")
    public GameModel updateStatus(@PathVariable Long id, @RequestBody GameModel gameModel) {
        return  gameService.updateStatusGame(id,gameModel);
    }
    
    
    
}
