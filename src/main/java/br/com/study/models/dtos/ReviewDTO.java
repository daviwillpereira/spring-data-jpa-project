package br.com.study.models.dtos;

import br.com.study.models.Course;
import br.com.study.models.Review;
import br.com.study.models.enums.ReviewRating;

public class ReviewDTO {

	private final Long id;

	private final ReviewRating rating;

	private final String description;

	private CourseDTO course;

	public ReviewDTO() {
		this(0L, null, null, null);
	}

	public ReviewDTO(Review review) {
		this(review.getId(), review.getRating(), review.getDescription(), new CourseDTO());
	}

	public ReviewDTO(Long id, ReviewRating rating, String description, CourseDTO course) {
		this.id = id;
		this.rating = rating;
		this.description = description;
		this.course = course;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public Review toEntity(Course curso) {
		return new Review(null, rating, description, curso);
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

}
