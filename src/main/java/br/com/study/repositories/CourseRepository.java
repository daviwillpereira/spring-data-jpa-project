package br.com.study.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.study.models.Course;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long>{

	Optional<Course> findByName(String name);
	
}
