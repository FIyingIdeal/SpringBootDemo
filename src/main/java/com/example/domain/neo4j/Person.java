package com.example.domain.neo4j;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Person")
public class Person {
	@GraphId
	private Long id;
	
	@Property(name = "name")
	private String fullName;
	
	/*@Relationship(type = "Acted")
	private List<Movie> filmography = new ArrayList<>();*/

	@Relationship(type = "Acted")
	private List<Acted> acted;
	
	public Person() {
		super();
	}
	
	public Person(Long id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}
	
	public Person(String fullName) {
		super();
		this.fullName = fullName;
	}
	
	public Person(Long id, String fullName, List<Acted> acted) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.acted = acted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Acted> getActed() {
		return acted;
	}

	public void setActed(List<Acted> acted) {
		this.acted = acted;
	}

	/*public List<Movie> getFilmography() {
		return filmography;
	}

	public void setFilmography(List<Movie> filmography) {
		this.filmography = filmography;
	}*/
	
}
