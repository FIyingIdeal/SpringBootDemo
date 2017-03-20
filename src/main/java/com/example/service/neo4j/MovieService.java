package com.example.service.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.neo4j.MovieRepository;
import com.example.domain.neo4j.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie getMovieFromId(int id) {
		return movieRepository.getMovieFromId(id);
	}
	
	public Movie getMovieFromTitle(String movieTitle) {
		return movieRepository.getMovieFromTitle(movieTitle);
	}
	
	public Movie saveMovie(String name, int year) {
		return movieRepository.save(new Movie(name, year));
	}
	
}
