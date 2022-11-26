package hu.bme.aut.archerybe.datamodel.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "trainings")
@Getter
@Setter
public class Training extends BaseEntity {

    private Statistics statistics;

    @DocumentReference
    private Set<Round> rounds;

    @DocumentReference(lazy = true)
    private User user;

    private boolean isPrivate;

}
