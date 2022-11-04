package hu.bme.aut.archerybe.datamodel.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Round extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;
}
