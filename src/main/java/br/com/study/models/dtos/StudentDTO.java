package br.com.study.models.dtos;

import br.com.study.models.Address;
import br.com.study.models.Passport;
import br.com.study.models.Student;

public class StudentDTO {

	private final Long id;

	private final String name;

	private final AddressDTO address;

	private final PassportDTO passport;

	public StudentDTO() {
		this(0L, null, null, null);
	}

	public StudentDTO(Student student) {
		this(student.getId(), student.getName(), new AddressDTO(student.getAddress()),
				new PassportDTO(student.getPassport()));
	}

	public StudentDTO(Long id, String name, AddressDTO address, PassportDTO passport) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PassportDTO getPassport() {
		return passport;
	}

	public Student toEntity(Long id) {
		return new Student(id, name, new Address(address.getLine1(), address.getLine2(), address.getCity()),
				new Passport(passport.getId(), passport.getNumber()));
	}

}
