package com.example.controller.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyConfiguration;
import com.example.domain.neo4j.Acted;
import com.example.service.neo4j.ActedInService;

@RestController
@EnableAutoConfiguration
@Import(MyConfiguration.class)
@RequestMapping(value = "/relationship")
public class ActedInController {
	
	@Autowired
	private ActedInService actedInService;
	
	@RequestMapping(value = "/saveAcedIn/{personName}/{movieName}/{movieYear}")
	public Acted saveActedIn(@PathVariable String personName, @PathVariable String movieName, @PathVariable int movieYear) {
		return actedInService.testSaveRelationShip(personName, movieName, movieYear);
	}
	
	@RequestMapping(value = "/saveAcedInByName/{personName}/{movieName}")
	public Acted saveActedIn(@PathVariable String personName, @PathVariable String movieName) {
		return actedInService.testSaveRelationShip(personName, movieName);
	}

}
