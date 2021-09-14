package com.demo.category.service;

import com.demo.category.model.dto.CategoryDTO;
import com.demo.category.model.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
	List<CategoryDTO> getAll();

	CategoryDTO insert(CategoryDTO category);

	void delete(Long id);

	CategoryDTO  findById(Long categoryId);
}
