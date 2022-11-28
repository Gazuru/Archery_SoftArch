package hu.bme.aut.archerybe.datamodel.repository;

import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomMongoRepository<T extends BaseEntity> extends MongoRepository<T, UUID> {
}
