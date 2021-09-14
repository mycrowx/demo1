package com.demo.category.service;

import com.demo.category.model.dto.CategoryDTO;
import com.demo.category.model.entity.CategoryEntity;
import com.demo.category.repository.ICategoryJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private ICategoryJpaRepository repository;

	@Override
	public List<CategoryDTO> getAll() {
		ArrayList<CategoryEntity> categories = (ArrayList<CategoryEntity>) repository.findAll();

		ModelMapper modelMapper = new ModelMapper();

		return categories
				.stream()
				.map(category -> modelMapper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO findById(Long id) {
		CategoryEntity category = repository.findById(id).orElse(null);

		if(category == null) return null;

		return new ModelMapper().map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO insert(CategoryDTO category) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CategoryEntity categoryEntity = repository.save(modelMapper.map(category, CategoryEntity.class));

		return modelMapper.map(categoryEntity, CategoryDTO.class);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
