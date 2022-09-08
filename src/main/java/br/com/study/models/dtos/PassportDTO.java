package br.com.study.models.dtos;

import br.com.study.models.Passport;

public class PassportDTO {

	private Long id;

	private String number;

	public PassportDTO() {
		this(0L, null);
	}

	public PassportDTO(Passport passport) {
		this(passport.getId(), passport.getNumber());
	}

	public PassportDTO(Long id, String number) {
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
