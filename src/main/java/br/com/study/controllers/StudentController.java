package br.com.study.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.models.dtos.StudentDTO;
import br.com.study.models.dtos.StudentSummaryDTO;
import br.com.study.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<Page<StudentSummaryDTO>> list(
			@PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.list(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable(required = true) Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
	}

	@PostMapping
	public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO student) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.save(student));
	}

}
