package att.sage.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import att.sage.models.Course;
import att.sage.models.Review;
import att.sage.models.dtos.CourseDTO;
import att.sage.models.dtos.ReviewDTO;
import att.sage.repositories.CourseRepository;
import att.sage.repositories.ReviewRepository;

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
