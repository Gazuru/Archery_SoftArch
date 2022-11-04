package hu.bme.aut.archerybe.datamodel.repository;

import java.util.Optional;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, UUID> {
    Optional<Statistics> findByTrainingId(UUID id);
}
