package hu.bme.aut.archerybe.datamodel.entity;

import java.io.Serializable;

import hu.bme.aut.archerybe.datamodel.entity.converter.BowTypeConverter;
import hu.bme.aut.archerybe.datamodel.entity.enums.BowType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bow extends BaseEntity implements Serializable {

    @Convert(converter = BowTypeConverter.class)
    private BowType bowType;
}
