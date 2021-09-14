package com.demo.category.repository;

import com.demo.category.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
}
