package hu.bme.aut.archerybe.datamodel.entity;

import hu.bme.aut.archerybe.datamodel.enums.StatisticsType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "statistics")
public class Statistics extends BaseEntity {

    private StatisticsType statisticsType;

    private Double accuracyPercentageAverage;

    private Double highestAccuracyPercentage;

    private Double lowestAccuracyPercentage;

}
