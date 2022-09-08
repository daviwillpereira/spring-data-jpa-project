package br.com.study.models.dtos;

import br.com.study.models.Course;

public class CourseDTO {

	private final Long id;

	private final String name;

	public CourseDTO() {
		this(0L, null);
	}

	public CourseDTO(Course course) {
		this(course.getId(), course.getName());
	}

	public CourseDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
