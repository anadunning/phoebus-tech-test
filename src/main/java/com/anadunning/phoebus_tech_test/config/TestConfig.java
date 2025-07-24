package com.anadunning.phoebus_tech_test.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;
import com.anadunning.phoebus_tech_test.models.entities.Exchange;
import com.anadunning.phoebus_tech_test.models.entities.Resource;
import com.anadunning.phoebus_tech_test.repositories.CommunityCentreRepository;
import com.anadunning.phoebus_tech_test.repositories.ExchangeRepository;
import com.anadunning.phoebus_tech_test.repositories.ResourceRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private CommunityCentreRepository centreRepository;
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	@Autowired
	private ExchangeRepository exchangeRepository;	
	
	@PostConstruct
	public void init() {
		
		centreRepository.deleteAll();
		resourceRepository.deleteAll();
        exchangeRepository.deleteAll();
		
		CommunityCentre caboVerde = new CommunityCentre(null, "Centro Cabo Verde", 100, 91, true);
		CommunityCentre belize = new CommunityCentre(null, "Centro Belize", 200, 100, false);
		CommunityCentre canada = new CommunityCentre(null, "Centro Canada", 500, 20, false);
		CommunityCentre centre1 = new CommunityCentre(null, "Centro Norte", 100, 95, true);
        CommunityCentre centre2 = new CommunityCentre(null, "Centro Sul", 120, 50, false);
        CommunityCentre centre3 = new CommunityCentre(null, "Centro Oeste", 80, 72, false);
		
		centreRepository.saveAll(Arrays.asList(caboVerde, belize, canada, centre1, centre2, centre3));
		
		Resource r1 = new Resource(null, "Cesta Básica", 100, 2, centre1.getId());
        Resource r2 = new Resource(null, "Médico", 4, 4, centre1.getId());
        Resource r3 = new Resource(null, "Veículo de transporte", 10, 5, centre2.getId());
        Resource r4 = new Resource(null, "Kit de suprimentos médicos", 20, 7, centre3.getId());
        Resource r5 = new Resource(null, "Cesta Básica", 60, 2, centre3.getId());
        Resource r6 = new Resource(null, "Voluntário", 20, 3, caboVerde.getId());
        Resource r7 = new Resource(null, "Veículo de transporte", 4, 5, caboVerde.getId());
        Resource r8 = new Resource(null, "Kit de suprimentos médicos", 50, 7, belize.getId());
        Resource r9 = new Resource(null, "Médico", 5, 4, belize.getId());
        Resource r10 = new Resource(null, "Cesta básica", 80, 2, canada.getId());
        
        resourceRepository.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10));
        
        Exchange e1 = new Exchange(null, LocalDateTime.now().minusDays(1), centre1.getId());
        Exchange e2 = new Exchange(null, LocalDateTime.now().minusHours(5), centre1.getId());
        Exchange e3 = new Exchange(null, LocalDateTime.now().minusDays(10), centre2.getId());
        Exchange e4 = new Exchange(null, LocalDateTime.now().minusWeeks(2), centre3.getId());
        
        exchangeRepository.saveAll(Arrays.asList(e1, e2, e3, e4));		
	}
}