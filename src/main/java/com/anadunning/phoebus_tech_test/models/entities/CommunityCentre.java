package com.anadunning.phoebus_tech_test.models.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "centres")
public class CommunityCentre {
	
	@Id
	private String id;
	private String name;
	private Integer maxNumPeople;
	private Integer currentNumPeople;
	private boolean hasReachedMaxCapacity = false;
	
	List<Resource> resources = new ArrayList<>();
	List<Exchange> exchanges = new ArrayList<>();
	
	public CommunityCentre() {
	}

	public CommunityCentre(String id, String name, Integer maxNumPeople, Integer currentNumPeople,
			boolean hasReachedMaxCapacity) {
		this.id = id;
		this.name = name;
		this.maxNumPeople = maxNumPeople;
		this.currentNumPeople = currentNumPeople;
		this.hasReachedMaxCapacity = hasReachedMaxCapacity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxNumPeople() {
		return maxNumPeople;
	}

	public void setMaxNumPeople(Integer maxNumPeople) {
		this.maxNumPeople = maxNumPeople;
	}

	public Integer getCurrentNumPeople() {
		return currentNumPeople;
	}

	public void setCurrentNumPeople(Integer currentNumPeople) {
		this.currentNumPeople = currentNumPeople;
	}

	public boolean isHasReachedMaxCapacity() {
		return hasReachedMaxCapacity;
	}

	public void setHasReachedMaxCapacity(boolean hasReachedMaxCapacity) {
		this.hasReachedMaxCapacity = hasReachedMaxCapacity;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public List<Exchange> getExchanges() {
		return exchanges;
	}

}
