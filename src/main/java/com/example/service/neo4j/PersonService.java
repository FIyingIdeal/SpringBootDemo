package com.example.service.neo4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.neo4j.ActedInRepository;
import com.example.dao.neo4j.PersonRepository;
import com.example.domain.neo4j.Acted;
import com.example.domain.neo4j.Movie;
import com.example.domain.neo4j.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private ActedInRepository actedInRepository;
	
	public Person getPersonFromName(String fullName) {
		return personRepository.getPersonFromName(fullName);
	}
	
	public Iterable<Map<String, Object>> /*Map<String, Object>*/ getPersonFromNameWithActedIn(String fullName) {
		return personRepository.getPersonFromNameWithActedIn(fullName);
	}
	
	public Person getPersonFromId(Long id) {
		return personRepository.findOne(id);
	}
	
	public Person savePerson(String fullName) {
		return personRepository.save(new Person(fullName));
	}
	
	public void deletePerson(Long id) {
		personRepository.delete(id);
	}
	
	public Object getActedInRelationShip() {
		return actedInRepository.getRelationShip();
	}
	
	public Person actedInMovie(Long personId) {
		Person person = personRepository.findOne(personId);
		Movie movie = new Movie("I Love You", 2016);
		Acted acted = new Acted();
		acted.setPerson(person);
		acted.setMovie(movie);
		acted.setRoles("man");
		List<Acted> list = new ArrayList<Acted>();
		list.add(acted);
		person.setActed(list);
		return personRepository.save(person);
	}
}
