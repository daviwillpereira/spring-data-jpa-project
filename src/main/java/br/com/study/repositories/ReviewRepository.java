package br.com.study.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.study.models.Review;


@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
