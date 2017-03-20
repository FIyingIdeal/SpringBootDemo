package com.example.controller.neo4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyConfiguration;
import com.example.domain.neo4j.Person;
import com.example.service.neo4j.PersonService;

@RestController
@EnableAutoConfiguration
@Import(MyConfiguration.class)
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/getPersonFromName/{name}")
	public Person getPersonFromName(@PathVariable String name) {
		return personService.getPersonFromName(name);
	}
	
	@RequestMapping("/getPersonFromNameWithActedIn/{name}")
	public Iterable<Map<String, Object>> /*Map<String, Object>*/ getPersonFromNameWithActedIn(@PathVariable String name) {
		Iterable<Map<String, Object>> obj= personService.getPersonFromNameWithActedIn(name);
		return obj;
	}
	
	@RequestMapping("/getPersonFromId/{id}")
	public Person getPersonFromId(@PathVariable Long id) {
		return personService.getPersonFromId(id);
	}
	
	@RequestMapping("/savePerson/{name}")
	public Person savePerson(@PathVariable String name) {
		return personService.savePerson(name);
	}
	
	@RequestMapping("/deletePerson/{id}")
	public void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}
	
	@RequestMapping("/getActedInRelationShip")
	public Object getActedInRelationShip() {
		return personService.getActedInRelationShip();
	}
	
	@RequestMapping("/actedInMovie/{personId}")
	public Person actedInMovie(@PathVariable Long personId) {
		return personService.actedInMovie(personId);
	}
}
