package hu.bme.aut.archerybe.datamodel.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Statistics extends BaseEntity {

    @OneToOne(mappedBy = "statistics")
    private Training training;

}
