package br.com.study.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.study.models.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{
	
	public Optional<Passport> findByNumber(String number);
}
