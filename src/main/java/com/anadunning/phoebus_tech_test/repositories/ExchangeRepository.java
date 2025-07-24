package com.anadunning.phoebus_tech_test.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.anadunning.phoebus_tech_test.models.entities.Exchange;

public interface ExchangeRepository extends MongoRepository<Exchange, String> {
	
	Long countByCentreId(String centreId);

    @Query("{ instant: { $gte: ?0, $lte: ?1 } }")
    List<Exchange> findExchangesBetween(LocalDateTime start, LocalDateTime end);	
	
	
	List<Exchange> findByCentreId(String centreId);

}
