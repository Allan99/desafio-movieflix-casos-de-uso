package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailsDTO> findMovieById(@PathVariable Long id){
		MovieDetailsDTO genresDTO = service.findMovieById(id);
		return ResponseEntity.ok(genresDTO);
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<Page<ReviewDTO>> findReviewsByMovieId(@PathVariable Long id, 
			Pageable pageable){
		
		Page<ReviewDTO> reviewsDTO = service.findReviewsByMovieId(id, pageable);
		return ResponseEntity.ok(reviewsDTO);
	}
}
