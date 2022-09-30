package hu.bme.aut.archerybe.datamodel.entity;

import hu.bme.aut.archerybe.datamodel.entity.converter.BowTypeConverter;
import hu.bme.aut.archerybe.genapi.business.dto.BowType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Bow extends BaseEntity implements Serializable {

    @Convert(converter = BowTypeConverter.class)
    private BowType bowType;
}
