package hu.bme.aut.archerybe.datamodel.repository;

import java.util.Set;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, UUID> {
    Set<Round> findAllByTrainingId(UUID trainingId);
}
