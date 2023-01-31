package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.howtodoinjava.demo.model.Movies;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "MovieController", description = "REST Apis related to Movies Entity!!!!")
@RestController
public class MovieController {

	static List<Movies.Film> FilmList = new ArrayList<Movies.Film>();
	static List<Movies.Actor> ActorList = new ArrayList<Movies.Actor>();

	static{
		FilmList .add(new Movies.Film("Nice","ss","FR","22-11-3333"));
		FilmList .add(new Movies.Film("Nice","ss","FR","22-11-3333"));
		FilmList .add(new Movies.Film("Nice","ss","FR","22-11-3333"));
		ActorList .add(new Movies.Actor("Nice","ss","22-11-3333",FilmList));

	}
	@ApiOperation(value = "Get list of actors by film ", response = Iterable.class, tags = "getActorsByFilm")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping("/Actors/{film}")
	public List<Movies.Actor> getActorsByFilm(String filmTitle) {
		List<Movies.Actor> result = new ArrayList<>();
		for (Movies.Actor actor : ActorList) {
			for (Movies.Film film : actor.getFilmography()) {
				if (film.getTitreFilm().equals(filmTitle)) {
					result.add(actor);
					break;
				}
			}
		}
		return result;
	}

	@ApiOperation(value = "Get Actor by name ", response = Iterable.class, tags = "getActorsByName")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping("/ActorSearch/{name}")
	public Movies.Actor getActorsByName(@PathVariable(value = "name") String name)
	{
		for (Movies.Actor actor : ActorList) {
			if (actor.getNom().equals(name)) {
				return actor;
			}
		}
		return null;
	}

	@RequestMapping("/Actors")
	public List<Movies.Actor> getAllActors()
	{

		return this.ActorList;
	}
	@RequestMapping("/Films")
	public List<Movies.Film> getAllFilms()
	{

		return this.FilmList;
	}
	@RequestMapping("/FilmTitleSearch/{titre}")
	public Movies.Film getFilmsBytitle(@PathVariable(value = "titre") String titre)
	{
		for (Movies.Film film : FilmList) {
			if (film.getTitreFilm().equals(titre)) {
				return film;
			}
		}
		return null;
	}
	@RequestMapping("/FilmsSearchByDate/{Date}")
	public List<Movies.Film> getFilmsByReleaseYear(@PathVariable(value = "Date") String date) {
		List<Movies.Film> result = new ArrayList<>();
		for (Movies.Film film : FilmList) {
			if (film.getDateSortie()== date) {
				result.add(film);
			}
		}
		return result;
	}
}


