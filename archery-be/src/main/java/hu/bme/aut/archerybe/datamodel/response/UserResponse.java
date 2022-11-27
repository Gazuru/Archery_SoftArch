package hu.bme.aut.archerybe.datamodel.response;

import java.util.List;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Authority;

public record UserResponse(
        UUID id,
        String username,
        String email,
        Authority authority,
        List<UUID> trainings
) {
}
