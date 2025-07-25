package com.anadunning.phoebus_tech_test.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resources")
public class Resource {
	
	@Id
	private String id;
	private String description;
	private Integer quantity;
	private Integer value;
	private String centreId;

	public Resource() {
	}

	public Resource(String id, String description, Integer quantity, Integer value, String centreId) {
		super();
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.value = value;
		this.centreId = centreId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

}
