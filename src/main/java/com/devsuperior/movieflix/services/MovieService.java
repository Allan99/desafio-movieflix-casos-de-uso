package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public MovieDetailsDTO findMovieById(Long id) {
		Optional<Movie> optionalMovie = repository.findById(id);
		Movie movie = optionalMovie.get();
		return new MovieDetailsDTO(movie);
	}

	@Transactional(readOnly = true)
	public Page<ReviewDTO> findReviewsByMovieId(Long id, Pageable pageable) {
		Page<Review> reviews = repository.searchReviewsByMovieId(id, pageable);
		return reviews.map(r -> new ReviewDTO(r));
	}
	
	
}
