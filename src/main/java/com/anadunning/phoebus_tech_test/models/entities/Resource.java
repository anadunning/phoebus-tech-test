package com.anadunning.phoebus_tech_test.models.entities;

public class Resource {
	
	private String id;
	private String description;
	private Integer quantity;
	private Integer value;
	
	private CommunityCentre centre;

	public Resource() {
	}

	public Resource(String id, String description, Integer quantity, Integer value, CommunityCentre centre) {
		super();
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.value = value;
		this.centre = centre;
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

	public CommunityCentre getCentre() {
		return centre;
	}

	public void setCentre(CommunityCentre centre) {
		this.centre = centre;
	}
	

}
