package com.capg.ocma.model;

import org.springframework.stereotype.Component;

@Component
public class AddressDTO {
	
	private String street;
	private String city;
	private String state;
	private String country;
	private int zip;

	public AddressDTO() {
		super();
	}

	public AddressDTO(String street, String city, String state, String country, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "AddressDTO [street=" + street + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zip=" + zip + "]";
	}

}
