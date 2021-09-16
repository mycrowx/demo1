package com.demo.movie.service;

import com.demo.movie.model.dto.MovieDTO;
import com.demo.movie.model.entity.MovieEntity;
import com.demo.movie.repository.IMovieJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
	@Autowired
	private IMovieJpaRepository repository;

	@Override
	public List<MovieDTO> getAll() {
		ArrayList<MovieEntity> movies = (ArrayList<MovieEntity>) repository.findAll();

		ModelMapper modelMapper = new ModelMapper();

		return movies
				.stream()
				.map(movie -> modelMapper.map(movie, MovieDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public MovieDTO findById(Long id) {
		MovieEntity movie = repository.findById(id).orElse(null);
		if(movie == null) return null;

		return new ModelMapper().map(movie, MovieDTO.class);
	}

	@Override
	public MovieDTO insert(MovieDTO movie) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieEntity movieEntity = repository.save(modelMapper.map(movie, MovieEntity.class));

		return modelMapper.map(movieEntity, MovieDTO.class);
	}

	@Override
	public MovieDTO update(MovieDTO movie) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieEntity movieEntity = repository.save(modelMapper.map(movie, MovieEntity.class));

		return modelMapper.map(movieEntity, MovieDTO.class);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
