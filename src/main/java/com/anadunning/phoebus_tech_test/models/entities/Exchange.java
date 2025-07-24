package com.anadunning.phoebus_tech_test.models.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exchanges")
public class Exchange {
	
	@Id
	private String id;
	private LocalDateTime instant;
	private String centreId;

	public Exchange() {
	}

	public Exchange(String id, LocalDateTime instant, String centreId) {
		this.id = id;
		this.instant = instant;
		this.centreId = centreId;
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

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

		
}
