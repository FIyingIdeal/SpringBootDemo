package com.example.dao.neo4j;

import com.example.domain.neo4j.Person;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface PersonRepository extends GraphRepository<Person> {

	@Query("MATCH (person:Person {name:{0}}) - [:ACTED_IN] -> (movie:Movie) RETURN person,movie")
	Iterable<Map<String, Object>> getPersonFromNameWithActedIn(String name);
	//Person getPersonFromNameWithActedIn(String name);
	
	@Query("MATCH (person:Person {name:{0}}) RETURN person")
	Person getPersonFromName(String name);

}
