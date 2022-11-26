package hu.bme.aut.archerybe.datamodel.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@Document(collection = "rounds")
@CompoundIndex(def = "{'training': 1, 'roundNumber': 1}", unique = true)
public class Round extends BaseEntity {

    @DocumentReference(lazy = true)
    private Training training;

    private int score;

    private int roundNumber;
}
