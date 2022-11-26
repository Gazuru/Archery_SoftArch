package hu.bme.aut.archerybe.datamodel.entity;

import java.util.Set;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Training extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistics_id")
    private Statistics statistics;

    @OneToMany(mappedBy = "training")
    private Set<Round> rounds;

}
