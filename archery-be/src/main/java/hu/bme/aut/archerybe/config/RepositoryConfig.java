package hu.bme.aut.archerybe.config;

import hu.bme.aut.archerybe.datamodel.repository.CustomMongoRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "hu.bme.aut.archerybe.datamodel.repository", repositoryBaseClass =
        CustomMongoRepositoryImpl.class)
public class RepositoryConfig {
}
