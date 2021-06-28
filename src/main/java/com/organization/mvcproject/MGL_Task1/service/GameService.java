package com.organization.mvcproject.MGL_Task1.service;

import java.util.ArrayList;
import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.Game;

public interface GameService {

	ArrayList<Game> retrieveAllGames();

	Game saveGame(Game game);

}



