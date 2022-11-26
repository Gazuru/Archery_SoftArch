package hu.bme.aut.archerybe.datamodel.entity;

import java.io.Serializable;

import hu.bme.aut.archerybe.datamodel.entity.enums.BowType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "bows")
public class Bow extends BaseEntity implements Serializable {

    private BowType bowType;
}
