package hu.bme.aut.archerybe.datamodel.entity;

import java.util.HashSet;
import java.util.Set;

import hu.bme.aut.archerybe.datamodel.enums.Location;
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
    private Set<Round> rounds = new HashSet<>();

    @DocumentReference(lazy = true)
    private User user;

    private boolean isPrivate;

    private String name;

    private Location location;

    private int shotsPerRound;

    private int distance;

    private int maxPoints;

    private String board;

    private String description;

    private Bow bow;

}
