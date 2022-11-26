package hu.bme.aut.archerybe.datamodel.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@Document(collection = "rounds")
public class Round extends BaseEntity {

    @DocumentReference(lazy = true)
    private Training training;
}
