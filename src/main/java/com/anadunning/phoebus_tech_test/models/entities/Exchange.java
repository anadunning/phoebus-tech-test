package com.anadunning.phoebus_tech_test.models.entities;

import java.util.Date;

public class Exchange {
	
	private String id;
	private Date instant;
	
	private CommunityCentre centre;

	public Exchange() {
	}

	public Exchange(String id, Date instant, CommunityCentre centre) {
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

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public CommunityCentre getCentre() {
		return centre;
	}

	public void setCentre(CommunityCentre centre) {
		this.centre = centre;
	}
	
	
}
