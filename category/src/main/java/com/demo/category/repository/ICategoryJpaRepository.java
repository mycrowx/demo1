package com.demo.category.repository;

import com.demo.category.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
}
