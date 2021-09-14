package com.demo.category.service;

import com.demo.category.model.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
	List<MovieDTO> getAll();

	MovieDTO insert(MovieDTO movie);

	void delete(Long id);

	MovieDTO findById(Long movieId);
}
