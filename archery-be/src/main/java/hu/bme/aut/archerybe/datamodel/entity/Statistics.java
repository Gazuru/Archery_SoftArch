package hu.bme.aut.archerybe.datamodel.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "statistics")
public class Statistics extends BaseEntity {

    private String details;

}
