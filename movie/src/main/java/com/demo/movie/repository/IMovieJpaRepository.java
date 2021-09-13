package com.demo.movie.repository;

import com.demo.movie.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}
