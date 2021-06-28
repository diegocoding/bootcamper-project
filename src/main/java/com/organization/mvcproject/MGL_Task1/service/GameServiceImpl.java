package com.organization.mvcproject.MGL_Task1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organizatoin.mvproject.dao.MockDAO;

@Service("javaGameService")
public class GameServiceImpl implements GameService {

	
	@Autowired
	private MockDAO  mockDao;  
	

	@Override
	public ArrayList<Game> retrieveAllGames() {
		return mockDao.retrieveAllGames();
	}
	
	
	public Game findGameById(Long id) {
		return mockDao.findGameById(id);
	}
	

	
	public boolean deleteGame(Long id) {
		return mockDao.deleteGame(id);
		
	}
	
	@Override
	public Game saveGame(Game game) {
		return mockDao.saveGame(game);
	}

	
	
}
	
	
	


