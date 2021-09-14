package com.demo.category.model.request;

import com.demo.category.model.dto.CategoryDTO;

public class CategoryCreateRequest {
	@NotNull(message = "name cannot be null")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
