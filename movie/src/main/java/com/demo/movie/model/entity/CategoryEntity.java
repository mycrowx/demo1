package com.demo.movie.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @SequenceGenerator(
        name = "category_id_seq_gen",
        sequenceName = "category_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "category_id_seq_gen"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "category",
        fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE,
        orphanRemoval = true
    )
    private List<MovieEntity> movies = new ArrayList<MovieEntity>();

    public CategoryEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return (
            "CategoryEntity{" +
            "id=" +
            id +
            ", name='" +
            name +
            '\'' +
            ", movies=" +
            movies +
            '}'
        );
    }
}
