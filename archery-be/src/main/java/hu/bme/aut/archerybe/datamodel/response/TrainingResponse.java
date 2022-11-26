package hu.bme.aut.archerybe.datamodel.response;

import java.util.Set;
import java.util.UUID;

public record TrainingResponse(
        UUID id,
        StatisticsResponse statistics,
        Set<UUID> rounds,
        UUID user,
        Boolean isPrivate,
        String name,
        String location,
        Integer shotsPerRound,
        Integer distance,
        Integer maxPoints,
        String board,
        String description
) {
}
