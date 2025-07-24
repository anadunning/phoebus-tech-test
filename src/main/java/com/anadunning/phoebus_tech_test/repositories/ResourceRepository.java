package com.anadunning.phoebus_tech_test.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.anadunning.phoebus_tech_test.models.dto.ResourceAverageDTO;
import com.anadunning.phoebus_tech_test.models.entities.Resource;

public interface ResourceRepository extends MongoRepository<Resource, String> {
	
	@Aggregation(pipeline = {
		    "{ $group: { _id: \"$description\", totalQuantity: { $sum: \"$quantity\" } } }",
		    "{ $lookup: { from: \"centres\", pipeline: [ { $count: \"count\" } ], as: \"centreCount\" } }",
		    "{ $unwind: \"$centreCount\" }",
		    "{ $project: { description: \"$_id\", _id: 0, averagePerCentre: { $divide: [\"$totalQuantity\", \"$centreCount.count\"] } } }"
		})
		List<ResourceAverageDTO> averageResourcePerCentre();

	 	List<Resource> findByCentreId(String centreId);
}
