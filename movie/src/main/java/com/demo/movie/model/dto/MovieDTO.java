package com.demo.movie.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class MovieDTO {
	private Long id;
	private String title;
//	@JsonBackReference
//	private CategoryDTO category;

	public MovieDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public CategoryDTO getCategory() {
//		return category;
//	}
//
//	public void setCategory(CategoryDTO category) {
//		this.category = category;
//	}
}
