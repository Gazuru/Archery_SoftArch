package hu.bme.aut.archerybe.datamodel.dto;

public record TrainingDto(
        String name,
        String location,
        Integer shotsPerRound,
        Integer distance,
        Integer maxPoints,
        String board,
        String description
) {
}
