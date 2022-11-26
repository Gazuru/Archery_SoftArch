package hu.bme.aut.archerybe.datamodel.repository;

import java.util.Optional;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
