package com.anadunning.phoebus_tech_test.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;
import com.anadunning.phoebus_tech_test.repositories.CommunityCentreRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private CommunityCentreRepository centreRepository;
	
	@PostConstruct
	public void init() {
		
		centreRepository.deleteAll();
		
		CommunityCentre caboVerde = new CommunityCentre(null, "Centro Cabo Verde", 100, 0, false);
		CommunityCentre belize = new CommunityCentre(null, "Centro Belize", 200, 0, false);
		CommunityCentre canada = new CommunityCentre(null, "Centro Canada", 500, 20, false);
		
		centreRepository.saveAll(Arrays.asList(caboVerde, belize, canada));
	}
}