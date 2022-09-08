package br.com.study.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.study.exceptions.NotFoundException;
import br.com.study.models.Student;
import br.com.study.models.dtos.StudentDTO;
import br.com.study.models.dtos.StudentSummaryDTO;
import br.com.study.repositories.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Page<StudentSummaryDTO> list(Pageable pageable) {
		return this.studentRepository.list(pageable);
	}

	public StudentDTO findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent()) {
			throw new NotFoundException(String.format("Student %s not found!", id));
		}

		return new StudentDTO(student.get());
	}

	public StudentDTO save(StudentDTO dto) {
		Optional<Student> student = studentRepository.findById(dto.getId());

		student.ifPresentOrElse(e -> new IllegalArgumentException("Student already exists!"),
				() -> studentRepository.save(dto.toEntity(dto.getId())));

		return dto;
	}

}
