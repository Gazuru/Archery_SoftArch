package hu.bme.aut.archerybe.datamodel.repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.BaseEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class CustomMongoRepositoryImpl<T extends BaseEntity> extends SimpleMongoRepository<T, UUID> implements CustomMongoRepository<T> {

    CustomMongoRepositoryImpl(MongoEntityInformation<T, UUID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }

    @Override
    public <S extends T> S insert(S entity) {
        generateId(entity);
        return super.insert(entity);
    }

    @Override
    public <S extends T> List<S> insert(Iterable<S> entities) {
        entities.forEach(this::generateId);
        return super.insert(entities);
    }

    @Override
    public <S extends T> S save(S entity) {
        generateId(entity);
        return super.save(entity);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::generateId);
        return super.saveAll(entities);
    }

    protected <S extends T> void generateId(S entity) {
        if (Objects.isNull(entity.getId())) {
            entity.setId(UUID.randomUUID());
        }
    }
}
