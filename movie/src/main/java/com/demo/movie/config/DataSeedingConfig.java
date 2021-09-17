package com.demo.movie.config;

import com.demo.movie.model.entity.CategoryEntity;
import com.demo.movie.model.entity.MovieEntity;
import com.demo.movie.repository.IMovieJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingConfig {

    @Autowired
    private IMovieJpaRepository repository;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        if (repository.findById(1L) == null) {
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setTitle("The Office");
            movieEntity.setCategory(new CategoryEntity("Comedy", null));

            repository.save(movieEntity);
        }
    }
}
