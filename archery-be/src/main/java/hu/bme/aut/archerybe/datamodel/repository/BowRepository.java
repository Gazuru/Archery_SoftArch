package hu.bme.aut.archerybe.datamodel.repository;

import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Bow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowRepository extends JpaRepository<Bow, UUID> {
}
