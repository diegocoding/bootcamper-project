package com.organization.mvcproject.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.api.dao.GameMockDAO;


@Repository
public class MockDAO implements GameMockDAO{
		

		private static Long gameId = new Long(0);
		
		private static List<Game> games = new ArrayList<Game>();

		static {
			games = populateGames();
		}

	private static List<Game> populateGames() {

			Game game1 = new Game();
			game1.setGameID(++gameId);
			game1.setGameGenre("Sport");
			game1.setGameName("Rocket League");

			Game game2 = new Game();
			game2.setGameID(++gameId);
			game2.setGameGenre("Shooter");
			game2.setGameName("Halo 3");

			Game game3 = new Game();
			game3.setGameID(++gameId);
			game3.setGameGenre("MMORPG");
			game3.setGameName("Runescape");

			games.add(game1);
			games.add(game2);
			games.add(game3);

			return games;
		}

		
		public List<Game> retrieveAllGames() {
			return games;
		}
		
		
		//create and udpate
		
		public Game saveGame(Game game) {
			if(game.getGameId() != null) {
				Game haveGame = findGameById(game.getGameId());
					if(haveGame != null) {
						
						
						for(int i = 0; i <games.size();i++) {
							Game currentGames = games.get(i);
							
							if(game.getGameId().equals(currentGames.getGameId())) {
								return games.set(i,game);
							}
						}
					}
			}
			game.setGameID(++gameId);
			games.add(game);
			return game;
		}

		
		public Game findGameById(Long id) {
			for(Game g: games) {
				if(id.equals(g.getGameId())) {
					return g;
				}
			}
			return null;
		}
		//delete
		public boolean deleteGame(Long id) {
			for(int i = 0; i < games.size(); i++) {
				games.remove(games.get(i));
				return true;
			}
			return false;
		}
		
		
		
	}

