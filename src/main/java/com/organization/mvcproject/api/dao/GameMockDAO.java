package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.Game;

 public interface GameMockDAO {
	
	 List<Game> retrieveAllGames();
	
	
	 Game saveGame(Game game);
					
	
	 Game findGameById(Long id);
	 
	 
	 boolean deleteGame(Long id);
	

}
