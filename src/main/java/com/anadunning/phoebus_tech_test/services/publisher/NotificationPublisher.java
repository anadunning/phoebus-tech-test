package com.anadunning.phoebus_tech_test.services.publisher;

import org.springframework.stereotype.Component;

import com.anadunning.phoebus_tech_test.models.entities.NotificationEvent;

@Component
public class NotificationPublisher {
	
	public void publish(NotificationEvent event) {
		System.out.println("[NOTIFICAÇÃO] Centro " + event.getCentreId() + ": " + event.getMessage());
	}

}
