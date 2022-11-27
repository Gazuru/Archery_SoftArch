package hu.bme.aut.archerybe.datamodel.repository;

import java.util.Set;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Round;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends MongoRepository<Round, UUID> {
    Set<Round> findAllByTrainingId(UUID trainingId);

    Round findFirstByOrderByRoundNumberDesc();
}
