package com.example.controller.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyConfiguration;
import com.example.domain.neo4j.Movie;
import com.example.service.neo4j.MovieService;

@RestController
@EnableAutoConfiguration
@Import(MyConfiguration.class)
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable int id) {
		return movieService.getMovieFromId(id);
	}
	
	@RequestMapping("/getMovieFromTitle/{movieTitle}")
	public Movie getMovieFromTitle(@PathVariable String movieTitle) {
		return movieService.getMovieFromTitle(movieTitle);
	}
	
	@RequestMapping("/saveMovie/{name}/{year}")
	public Movie saveMovie(@PathVariable String name, @PathVariable int year) {
		return movieService.saveMovie(name, year);
	}
	

}
