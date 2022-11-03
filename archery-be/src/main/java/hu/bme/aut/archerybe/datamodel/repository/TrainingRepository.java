package hu.bme.aut.archerybe.datamodel.repository;

import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
