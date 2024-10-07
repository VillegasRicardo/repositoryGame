package com.game.service_api.service;

import java.util.List;

import com.game.service_api.commons.entities.Game;

public interface GameService {
	
	Game saveGame(Game gameRequest);
	
	List<Game> getGameAll();
	
	List<Game> getGameByName(String nameRequest);
	
	Game getGameById(Long idRequest);
	
	Game updateStatusGame(Long id, Game gameRequest);
	
}
