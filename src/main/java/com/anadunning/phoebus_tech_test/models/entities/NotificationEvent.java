package com.anadunning.phoebus_tech_test.models.entities;

public class NotificationEvent {
	
	private String centreId;
	private String message;
	
	public NotificationEvent() {
	}
	
	public NotificationEvent(String centreId, String message) {
		this.centreId = centreId;
		this.message = message;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
