package att.sage.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import att.sage.exceptions.NotFoundException;
import att.sage.models.Student;
import att.sage.models.dtos.StudentDTO;
import att.sage.models.dtos.StudentSummaryDTO;
import att.sage.repositories.StudentRepository;

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
