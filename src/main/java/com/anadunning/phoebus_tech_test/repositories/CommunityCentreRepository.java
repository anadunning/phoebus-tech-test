package com.anadunning.phoebus_tech_test.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;

@Repository
public interface CommunityCentreRepository extends MongoRepository<CommunityCentre, String> {
	
	@Query("{ $expr: { $gt: [{ $divide: [\"$currentNumPeople\", \"$maxNumPeople\"] }, 0.9] } }")
    List<CommunityCentre> findHighOccupancy();
}
