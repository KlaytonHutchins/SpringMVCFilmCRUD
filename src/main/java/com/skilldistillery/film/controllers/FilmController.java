package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	@RequestMapping(path = "showFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView showFilm(@RequestParam("filmId") Integer filmId) {
		ModelAndView mav = new ModelAndView();
		Film film = filmDAO.findFilmById(filmId);
		mav.addObject("film", film);
		mav.setViewName("film");
		return mav;
	}
	
	@RequestMapping(path = "showFilm.do", method = RequestMethod.GET, params = "filmWord")
	public ModelAndView showFilm(@RequestParam("filmWord") String keyword) {
		ModelAndView mav = new ModelAndView();
		List<Film> films = filmDAO.findFilmByKeyword(keyword);
		mav.addObject("films", films);
		mav.setViewName("films");
		return mav;
	}
	
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) {
		InternalResourceView resourceView= new InternalResourceView("/index.html");
		ModelAndView mav = new ModelAndView(resourceView);
		Boolean bool = filmDAO.removeFilm(filmDAO.findFilmById(filmId));
//		mav.addObject("films", films);
		return mav;
	}
	
}
