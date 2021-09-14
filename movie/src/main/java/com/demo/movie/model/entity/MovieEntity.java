package com.demo.movie.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class MovieEntity implements Serializable {
	@Id
	@SequenceGenerator(name = "movie_id_seq_gen", sequenceName = "movie_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_seq_gen")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	public MovieEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "MovieEntity{" +
				"id=" + id +
				", title='" + title + '\'' +
				", category=" + category.toString() +
				'}';
	}
}
