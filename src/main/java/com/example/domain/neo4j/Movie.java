package com.example.domain.neo4j;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "Movie")
public class Movie {
	@GraphId
	private Long id;

	@Property(name="title")
	private String name;
	
	@Property(name="released")
	private int year;

	public Movie() {
		super();
	}

	public Movie(Long id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}
	
	public Movie(String name, int year) {
		super();
		this.name = name;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
