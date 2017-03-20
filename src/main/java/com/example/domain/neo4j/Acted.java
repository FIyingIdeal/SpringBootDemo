package com.example.domain.neo4j;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="ACTED_IN")
public class Acted {
	@GraphId
	private Long id;
	
	@Property
	private String roles;
	
	@StartNode
	private Person person;
	
	@EndNode
	private Movie movie;

	public Acted() {
		super();
	}

	public Acted(Long id, String roles, Person person, Movie movie) {
		super();
		this.id = id;
		this.roles = roles;
		this.person = person;
		this.movie = movie;
	}

	public Acted(String roles, Person person, Movie movie) {
		super();
		this.roles = roles;
		this.person = person;
		this.movie = movie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
