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

		List<MovieDTO> moviesDTO = movies
				.stream()
				.map(movie -> modelMapper.map(movie, MovieDTO.class))
				.collect(Collectors.toList());

		return moviesDTO;
	}

	@Override
	public MovieDTO findById(Long id) {
		MovieEntity movie = repository.findById(id).orElse(null);

		if(movie == null)
			return null;

		MovieDTO movieDTO = new ModelMapper().map(movie, MovieDTO.class);

		return movieDTO;
	}

	@Override
	public MovieDTO insert(MovieDTO movie) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);

		movieEntity = repository.save(movieEntity);

		movie = modelMapper.map(movieEntity, MovieDTO.class);

		return movie;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
