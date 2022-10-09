	package com.skilldistillery.film.controllers;
	
	import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Actor;
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
			try {
			film = filmDAO.createFilm(film);
			} catch (Exception e) {
				mav.setViewName("error");
				return mav;
			}
			mav.addObject("film", film);
			mav.setViewName("newfilm");
			return mav;
		}
	
		@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
		public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) {
			System.out.println(filmId);
			InternalResourceView resourceView= new InternalResourceView("/index.html");
			ModelAndView mav = new ModelAndView(resourceView);
			Boolean bool = filmDAO.removeFilm(filmDAO.findFilmById(filmId));
	//		mav.addObject("films", films);
			return mav;
		}
		
		@RequestMapping(path = "updateFilm.do", 
				params = { "filmId", "mTitle", "mDescription", "mLength", "mReleaseYear", "mRating", "mCategory" },
				method = RequestMethod.POST)
		public ModelAndView updateFilm(@RequestParam("filmId") int filmId,
									   @RequestParam("mTitle") String title,
									   @RequestParam("mDescription") String description,
									   @RequestParam("mLength") String length,
									   @RequestParam("mReleaseYear") String releaseYear,
									   @RequestParam("mRating") String rating,
									   @RequestParam("mCategory") String category
									   ) 
			{
			Film updateFilm = filmDAO.findFilmById(filmId); 
			ModelAndView mav = new ModelAndView();

			if (!title.isBlank()) updateFilm.setTitle(title);
			if (!description.isBlank()) updateFilm.setDescription(description);
			if (!length.isBlank()) updateFilm.setLength(Integer.parseInt(length));
			if (!releaseYear.isBlank()) updateFilm.setReleaseYear(Integer.parseInt(releaseYear));
			if (!rating.isBlank()) updateFilm.setRating(rating);
			if (!category.isBlank()) updateFilm.setCategory(category);
			System.out.println(filmId + title + description + length + releaseYear + rating + category);
			
			// I need to fill in nonsense values to cover the other stmt sets 
			if (updateFilm.getLanguage().isBlank()) updateFilm.setLanguage("English");
			updateFilm.setRentalDuration(0);
			updateFilm.setRentalRate(0.0);
			updateFilm.setReplacementCost(0.0);
			List<Actor> nullActorList = new ArrayList<>();
			updateFilm.setActors(nullActorList);
			try {
			filmDAO.updateFilm(updateFilm);
			} catch (Exception e) {
				mav.setViewName("error"); // created an error JSP
				return mav;
			}
			mav.addObject("film", updateFilm);
			mav.setViewName("film");
			return mav;
		}
		
	}
