package com.example.dao.neo4j;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import com.example.domain.neo4j.Movie;

@RepositoryRestController
public interface MovieRepository extends GraphRepository<Movie>{
	@Query("MATCH (n) WHERE id(n)={0} RETURN n")
	Movie getMovieFromId(Integer idOfMovie);

	@Query("MATCH (movie:Movie {title:{0}}) RETURN movie")
	Movie getMovieFromTitle(String movieTitle);
}
