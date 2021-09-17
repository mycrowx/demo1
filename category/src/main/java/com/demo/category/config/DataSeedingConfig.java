package com.demo.category.config;

import com.demo.category.model.entity.CategoryEntity;
import com.demo.category.repository.ICategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingConfig {

    @Autowired
    private ICategoryJpaRepository repository;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Comedy");

        repository.save(categoryEntity);
    }
}
