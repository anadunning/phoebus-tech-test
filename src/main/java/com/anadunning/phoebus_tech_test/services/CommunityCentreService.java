package com.anadunning.phoebus_tech_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anadunning.phoebus_tech_test.models.dto.CommunityCentreDTO;
import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;
import com.anadunning.phoebus_tech_test.repositories.CommunityCentreRepository;

@Service
public class CommunityCentreService {
	
	@Autowired
	private CommunityCentreRepository repository;
	
	public CommunityCentreDTO insert(CommunityCentreDTO dto) {
		CommunityCentre entity = new CommunityCentre();
		copyDTOToEntity(dto, entity);
		
		entity = repository.insert(entity);
		return new CommunityCentreDTO(entity);
	}
	
	private void copyDTOToEntity(CommunityCentreDTO dto, CommunityCentre entity) {
		entity.setName(dto.getName());
		entity.setMaxNumPeople(dto.getMaxNumPeople());
		entity.setCurrentNumPeople(dto.getCurrentNumPeople());
		entity.setHasReachedMaxCapacity(dto.isHasReachedMaxCapacity());
	}
}