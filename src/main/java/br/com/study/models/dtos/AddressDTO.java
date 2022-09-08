package br.com.study.models.dtos;

import br.com.study.models.Address;

public class AddressDTO {

	private final String line1;
	private final String line2;
	private final String city;

	public AddressDTO() {
		this(null, null, null);
	}

	public AddressDTO(Address address) {
		this(address.getLine1(), address.getLine2(), address.getCity());
	}

	public AddressDTO(String line1, String line2, String city) {
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getCity() {
		return city;
	}

}
