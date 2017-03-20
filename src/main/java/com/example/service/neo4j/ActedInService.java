package com.example.service.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.neo4j.ActedInRepository;
import com.example.domain.neo4j.Acted;
import com.example.domain.neo4j.Movie;
import com.example.domain.neo4j.Person;

@Service
public class ActedInService {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private ActedInRepository actedInRepository;
	
	public Acted testSaveRelationShip(String personName, String movieName, int movieYear) {
		Person person = personService.getPersonFromName(personName);
		Movie movie = movieService.saveMovie(movieName, movieYear);
		Acted acted_in = new Acted("superMan", person, movie);
		return actedInRepository.save(acted_in);
	}
	
	public Acted testSaveRelationShip(String personName, String movieName) {
		Person person = personService.getPersonFromName(personName);
		Movie movie = movieService.getMovieFromTitle(movieName);
		Acted acted_in = new Acted("superMan", person, movie);
		return actedInRepository.save(acted_in);
	}

}
