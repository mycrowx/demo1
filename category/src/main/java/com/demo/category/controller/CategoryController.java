package com.demo.category.controller;

import com.demo.category.model.dto.CategoryDTO;
import com.demo.category.model.request.CategoryCreateRequest;
import com.demo.category.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
	@Autowired
	private ICategoryService service;

	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryCreateRequest categoryRequest) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CategoryDTO categoryDTO = modelMapper.map(categoryRequest, CategoryDTO.class);

		categoryDTO = service.insert(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
	}

	@GetMapping(value = "/{categoryId}")
	public ResponseEntity<CategoryDTO> getById(@PathVariable("categoryId") Long categoryId) {
		CategoryDTO categoryDTO = service.findById(categoryId);
		return categoryDTO != null ?
				ResponseEntity.status(HttpStatus.OK).body(categoryDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> categories = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(categories);
	}

	@DeleteMapping(path = "/{categoryId}")
	public ResponseEntity<Void> delete(@PathVariable Long categoryId) {
		if(service.findById(categoryId) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		service.delete(categoryId);
		return ResponseEntity.ok().build();
	}
}
