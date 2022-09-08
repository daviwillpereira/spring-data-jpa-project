package br.com.study.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.study.models.Course;
import br.com.study.models.Review;
import br.com.study.models.dtos.CourseDTO;
import br.com.study.models.dtos.ReviewDTO;
import br.com.study.repositories.CourseRepository;
import br.com.study.repositories.ReviewRepository;

@Service
public class ReviewService {

	private final ReviewRepository reviewRepository;

	private final CourseRepository courseRepository;

	public ReviewService(ReviewRepository reviewRepository, CourseRepository courseRepository) {
		this.reviewRepository = reviewRepository;
		this.courseRepository = courseRepository;
	}

	public ReviewDTO add(ReviewDTO dto) {
		Optional<Review> review = reviewRepository.findById(dto.getId());

		review.ifPresent(e -> new IllegalArgumentException("Review already exists!"));

		Optional<Course> course = courseRepository.findByName(dto.getCourse().getName());

		course.ifPresentOrElse(c -> {
			reviewRepository.save(dto.toEntity(c));
			dto.setCourse(new CourseDTO(c));
		},
				() -> new IllegalArgumentException("Course doesn't exist!"));
		
		return dto;
	}

}
