package hu.bme.aut.archerybe.datamodel.response;

import java.util.UUID;

public record TrainingResponse(
        UUID id,
        UUID statistics,
        UUID user,
        String username,
        Boolean isPrivate,
        String name,
        String location,
        Integer shotsPerRound,
        Integer distance,
        Integer maxPoints,
        String board,
        String description,
        UUID bow
) {
}
