package hu.bme.aut.archerybe.datamodel.repository;

import java.util.Optional;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, UUID> {
    Optional<Statistics> findByTrainingId(UUID id);
}
