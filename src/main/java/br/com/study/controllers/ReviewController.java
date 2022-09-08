package br.com.study.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.models.dtos.ReviewDTO;
import br.com.study.services.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping
	public ResponseEntity<ReviewDTO> save(@RequestBody ReviewDTO review) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reviewService.add(review));
	}

}
