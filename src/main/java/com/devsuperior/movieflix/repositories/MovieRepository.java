package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_REVIEW WHERE movie_id = :id")
	Page<Review> searchReviewsByMovieId(Long id, Pageable pageable);
	
}
