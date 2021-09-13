package com.demo.movie.controller;

import com.demo.movie.model.dto.CategoryDTO;
import com.demo.movie.model.dto.MovieDTO;
import com.demo.movie.model.request.MovieCreateRequest;
import com.demo.movie.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {
	@Autowired
	private IMovieService service;

	@PostMapping
	public ResponseEntity<MovieDTO> insert(@RequestBody MovieCreateRequest movieRequest) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDTO movieDTO = modelMapper.map(movieRequest, MovieDTO.class);

//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setId(movieRequest.getCategoryId());
//		movieDTO.setCategory(categoryDTO);

		movieDTO = service.insert(movieDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
	}

	@GetMapping(value = "/{movieId}")
	public ResponseEntity<MovieDTO> getById(@PathVariable("movieId") Long movieId) {
		MovieDTO movieDTO = service.findById(movieId);
		return (movieDTO != null) ? ResponseEntity.status(HttpStatus.OK).body(movieDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping()
	public ResponseEntity<List<MovieDTO>> getAll() {
		List<MovieDTO> movies = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(movies);
	}

	@DeleteMapping(path = "/{movieId}")
	public ResponseEntity<Void> delete(@PathVariable Long movieId) {
		if(service.findById(movieId) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		service.delete(movieId);
		return ResponseEntity.ok().build();
	}
}
