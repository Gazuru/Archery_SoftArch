package hu.bme.aut.archerybe.datamodel.dto;

import java.util.UUID;

public record TrainingDto(
        String name,
        String location,
        Integer shotsPerRound,
        Integer distance,
        Integer maxPoints,
        String board,
        String description,
        UUID bow,
        Boolean isPrivate
) {
}
