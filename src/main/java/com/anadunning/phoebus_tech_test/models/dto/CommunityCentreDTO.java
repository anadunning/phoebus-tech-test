package com.anadunning.phoebus_tech_test.models.dto;

import java.util.List;

import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;
import com.anadunning.phoebus_tech_test.models.entities.Exchange;
import com.anadunning.phoebus_tech_test.models.entities.Resource;

public class CommunityCentreDTO {
	
	private String id;
	private String name;
	private Integer maxNumPeople;
	private Integer currentNumPeople;
	private boolean hasReachedMaxCapacity;
	
//	private CommunityCentre centre;
	
	private List<Resource> resources;
	private List<Exchange> exchanges;
	
	public CommunityCentreDTO() {
	}

	public CommunityCentreDTO(String id, String name, Integer maxNumPeople, Integer currentNumPeople,
			boolean hasReachedMaxCapacity) {
		this.id = id;
		this.name = name;
		this.maxNumPeople = maxNumPeople;
		this.currentNumPeople = currentNumPeople;
		this.hasReachedMaxCapacity = hasReachedMaxCapacity;
	}
	
	public CommunityCentreDTO(CommunityCentre entity) {
		id = entity.getId();
		name = entity.getName();
		maxNumPeople = entity.getMaxNumPeople();
		currentNumPeople = entity.getCurrentNumPeople();
		hasReachedMaxCapacity = entity.isHasReachedMaxCapacity();
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
