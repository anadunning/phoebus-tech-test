package com.anadunning.phoebus_tech_test.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;

@Repository
public interface CommunityCentreRepository extends MongoRepository<CommunityCentre, String> {

}
