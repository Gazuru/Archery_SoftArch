package hu.bme.aut.archerybe.datamodel.entity;

import java.io.Serializable;
import javax.persistence.Convert;
import javax.persistence.Entity;

import hu.bme.aut.archerybe.datamodel.entity.converter.BowTypeConverter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bow extends BaseEntity implements Serializable {

    @Convert(converter = BowTypeConverter.class)
    private BowType bowType;
}
