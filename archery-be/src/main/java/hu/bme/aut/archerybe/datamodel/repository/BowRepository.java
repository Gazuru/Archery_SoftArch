package hu.bme.aut.archerybe.datamodel.repository;

import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Bow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowRepository extends MongoRepository<Bow, UUID> {
}
