package com.example.dao.neo4j;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.domain.neo4j.Acted;

@RepositoryRestController
public interface ActedInRepository extends GraphRepository<Acted>{

	@Query("MATCH () - [R:ACTED_IN] - () RETURN R")
	Object getRelationShip();
}
