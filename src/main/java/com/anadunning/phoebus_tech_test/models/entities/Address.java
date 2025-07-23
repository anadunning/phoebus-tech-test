package com.anadunning.phoebus_tech_test.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {
	
	@Id
	private String id;
	private String street;
	private Integer number;
	private String suburb;
	private String city;
	private String state;
	private String postCode;
	
	public Address() {
	}
	public Address(String id, String street, Integer number, String suburb, String city, String state,
			String postCode) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.suburb = suburb;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getSuburb() {
		return suburb;
	}
	
	public void setSuburb(String suburb) {
		this.suburb = suburb;
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
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
}