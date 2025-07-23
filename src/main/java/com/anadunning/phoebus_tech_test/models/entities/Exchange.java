package com.anadunning.phoebus_tech_test.models.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exchanges")
public class Exchange {
	
	@Id
	private String id;
	private LocalDateTime instant;
	
	private CommunityCentre centre;

	public Exchange() {
	}

	public Exchange(String id, LocalDateTime instant, CommunityCentre centre) {
		this.id = id;
		this.instant = instant;
		this.centre = centre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getInstant() {
		return instant;
	}

	public void setInstant(LocalDateTime instant) {
		this.instant = instant;
	}

	public CommunityCentre getCentre() {
		return centre;
	}

	public void setCentre(CommunityCentre centre) {
		this.centre = centre;
	}
	
	
}
