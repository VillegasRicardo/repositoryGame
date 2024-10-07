package com.game.service_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.game.service_api.commons.constants.ApiPathVariables;
import com.game.service_api.commons.entities.Game;


/**
 * API para gestionar las operaciones relacionadas con los juegos.
 */
@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {
	
	/**
	 * Maneja las solicitudes HTTP POST para guardar un juego.

	 * Este método recibe un objeto Game en el cuerpo de la solicitud y lo guarda en el sistema.
	 * Devuelve una respuesta HTTP que contiene el objeto Game guardado.
	 * 
	 * @param game El objeto Game que se va a guardar.
	 * @return Un ResponseEntity que contiene el objeto Game guardado.
	 */
    @PostMapping
	ResponseEntity<Game> saveGame(@RequestBody Game game); 
    
    /**
     * Obtiene todos los juegos.
     * @return una lista de todos los juegos
     */
    @GetMapping
	List<Game> getGameAll();
	
    /**
     * Obtiene una lista de juegos por el nombre.
     * @param name el nombre del juego
     * @return una lista de juegos que coinciden con el nombre
     */
    @GetMapping(value = "/names/{name}")
	List<Game> getGameByName(@PathVariable String name);
	
    /**
     * Obtiene un juego por su ID.
     * @param id el ID del juego
     * @return el modelo del juego que coincide con el ID
     */
    @GetMapping(value = "{id}")
    ResponseEntity<Game> getGameById(@PathVariable Long id);
	
    /**
     * Actualiza el estatus de un juego.
     * @param id el ID del juego
     * @param statusUpdateDTO el DTO que contiene el nuevo estatus
     * @return la entidad del juego actualizado
     */
    @PatchMapping(value = "/status/{id}")
	ResponseEntity<Game> updateStatus(@PathVariable Long id, @RequestBody Game game);
}
