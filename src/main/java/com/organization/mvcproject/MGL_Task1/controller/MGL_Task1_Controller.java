package com.organization.mvcproject.MGL_Task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.MGL_Task1.model.Review;
import com.organization.mvcproject.api.service.GameService;


@Controller
public class MGL_Task1_Controller {

	@Autowired
	private GameService javaGameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("review", "command", new Review());
	}


	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("games", "command", new Game());
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<?> fetchAllGames() {
		return new ResponseEntity<>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}

	@RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}