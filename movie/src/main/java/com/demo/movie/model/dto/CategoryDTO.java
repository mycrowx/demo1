package com.demo.movie.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
	private Long id;
	private String name;
	private List<MovieDTO> movies = new ArrayList<MovieDTO>();

	public CategoryDTO() {
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

	public List<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
}
