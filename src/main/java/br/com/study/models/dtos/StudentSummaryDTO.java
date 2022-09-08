package br.com.study.models.dtos;

import br.com.study.models.Student;

public class StudentSummaryDTO {

	private final Long id;

	private final String name;

	public StudentSummaryDTO() {
		this(0L, null);
	}

	public StudentSummaryDTO(Student student) {
		this(student.getId(), student.getName());
	}

	public StudentSummaryDTO(Long id, String name) {
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
