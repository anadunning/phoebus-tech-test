package com.anadunning.phoebus_tech_test.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anadunning.phoebus_tech_test.models.dto.CentreDetailsDTO;
import com.anadunning.phoebus_tech_test.models.dto.CommunityCentreDTO;
import com.anadunning.phoebus_tech_test.models.dto.ResourceAverageDTO;
import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;
import com.anadunning.phoebus_tech_test.models.entities.Exchange;
import com.anadunning.phoebus_tech_test.models.entities.NotificationEvent;
import com.anadunning.phoebus_tech_test.models.entities.Resource;
import com.anadunning.phoebus_tech_test.repositories.CommunityCentreRepository;
import com.anadunning.phoebus_tech_test.repositories.ExchangeRepository;
import com.anadunning.phoebus_tech_test.repositories.ResourceRepository;
import com.anadunning.phoebus_tech_test.services.CommunityCentreService;
import com.anadunning.phoebus_tech_test.services.publisher.NotificationPublisher;

@RestController
@RequestMapping(value = "/centres")
public class CommunityCentreController {

	@Autowired
	private CommunityCentreService service;

	@Autowired
	private CommunityCentreRepository centreRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@Autowired
	private NotificationPublisher notificationPublisher;

	@GetMapping
	public List<CommunityCentre> findAll() {
		return centreRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<CommunityCentreDTO> insert(@RequestBody CommunityCentreDTO obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}

	@GetMapping(value = "/{id}/details")
	public CentreDetailsDTO getCentreDetails(@PathVariable String id) {
		CommunityCentre centre = centreRepository.findById(id).orElseThrow();

		List<Resource> resources = resourceRepository.findByCentreId(id);
		List<Exchange> exchanges = exchangeRepository.findByCentreId(id);
		return new CentreDetailsDTO(centre, resources, exchanges);
	}

	@GetMapping("/high-occupancy")
	public List<CommunityCentre> getHighOccupancyCentres() {
		return centreRepository.findHighOccupancy();
	}
	
	@GetMapping("/avg-resource-per-centre")
	public ResponseEntity<List<ResourceAverageDTO>> getAverageResourcePerCentre() {
	    List<ResourceAverageDTO> results = resourceRepository.averageResourcePerCentre();
	    results.forEach(r -> System.out.printf("Recurso: %s | Média por centro: %.2f%n", r.getDescription(), r.getAveragePerCentre()));
	    return ResponseEntity.ok(results);
	}

	@GetMapping("/{id}/exchange-count")
	public Long getExchangeCountByCentre(@PathVariable String id) {
		return exchangeRepository.countByCentreId(id);
	}

	@GetMapping("/exchange-count")
	public Long getExchangeCountBetween(@RequestParam String from) {
		LocalDateTime start = LocalDateTime.parse(from);
		LocalDateTime end = LocalDateTime.now();
		return (long) exchangeRepository.findExchangesBetween(start, end).size();
	}
	
	@PutMapping("/{id}/update-occupancy")
    public ResponseEntity<CommunityCentre> updateOccupancy(@PathVariable String id, @RequestParam int currentNumPeople) {
        Optional<CommunityCentre> centreOpt = centreRepository.findById(id);

        if (centreOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CommunityCentre centre = centreOpt.get();
        centre.setCurrentNumPeople(currentNumPeople);
        boolean reached = currentNumPeople >= centre.getMaxNumPeople();
        centre.setHasReachedMaxCapacity(reached);
        centreRepository.save(centre);

        if (reached) {
            NotificationEvent event = new NotificationEvent(id, "Capacidade máxima atingida ou excedida.");
            notificationPublisher.publish(event);
        }

        return ResponseEntity.ok(centre);
    }
}
