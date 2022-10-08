package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	  public Film findFilmById(int filmId);
	  public List<Film> findFilmByKeyword(String keyword);
	  public Actor findActorById(int actorId);
	  public List<Actor> findActorsByName(String name);
	  
	  public List<Film> findFilmsByActorId(int actorId);
	  public List<Actor> findActorsByFilmId(int filmId);
	  
	  public Film createFilm(Film film);
	  public boolean updateFilm(Film film);
	  public boolean removeFilm(Film film);
	  public Actor createActor(Actor actor);
	  public boolean updateActor(Actor actor);
	  public boolean removeActor(Actor actor);
	
}
