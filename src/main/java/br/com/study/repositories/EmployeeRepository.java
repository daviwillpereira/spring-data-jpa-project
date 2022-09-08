package br.com.study.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.study.models.Employee;
import br.com.study.models.FullTimeEmployee;
import br.com.study.models.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
//	public List<Employee> retriveAllEmployee(){
//		return em.createQuery("select e from Employee e", Employee.class).getResultList();
//	}
	
	public List<FullTimeEmployee> retriveFullTimeEmployee(){
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	
	public List<PartTimeEmployee> retrivePartTimeEmployee(){
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
}
