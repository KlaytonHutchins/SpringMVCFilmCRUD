package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(path = "showFilm.do", 
			method = RequestMethod.GET, 
			params = { "inputFilmTitle", "inputFilmDescription", "inputFilmReleaseYear", "inputFilmLanguage", "inputFilmLength","inputFilmRating" } )
	public ModelAndView addFilm(@RequestParam("inputFilmTitle") String title,
								@RequestParam("inputFilmDescription") String description,
								@RequestParam("inputFilmReleaseYear") int releaseYear,
								@RequestParam("inputFilmLanguage") String filmLanguage,
								@RequestParam("inputFilmLength") int length,
								@RequestParam("inputFilmRating") String rating) {
		ModelAndView mav = new ModelAndView();
		Film film = new Film(); 
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguage(filmLanguage);
		film.setLength(length);
		film.setRating(rating);
		film.setRentalDuration(0);
		film.setRentalRate(0.0);
		film.setReplacementCost(0.0);
		film = filmDAO.createFilm(film);
		mav.addObject("film", film);
		mav.setViewName("newfilm");
		return mav;
	}
}
