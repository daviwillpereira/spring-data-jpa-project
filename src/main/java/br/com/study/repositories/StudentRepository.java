package br.com.study.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.study.models.Student;
import br.com.study.models.dtos.StudentSummaryDTO;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query("SELECT new br.com.study.models.dtos.StudentSummaryDTO(s.id, s.name) FROM Student s")
	Page<StudentSummaryDTO> list(Pageable pageable);
	
	List<Student> findByPassport_Number(String number);
	
	Optional<Student> findByName(String name);
	
	
	
}
