package com.demo.movie.service;

import com.demo.movie.model.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {
	List<MovieDTO> getAll();

	MovieDTO insert(MovieDTO movie);

	void delete(Long id);

	MovieDTO findById(Long movieId);

	MovieDTO update(MovieDTO movie);
}
