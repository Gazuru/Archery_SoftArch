package hu.bme.aut.archerybe.datamodel.response;

import java.util.UUID;

public record RoundResponse(
        UUID id,
        UUID trainingId,
        Integer score,
        Integer roundNumber
) {
}
