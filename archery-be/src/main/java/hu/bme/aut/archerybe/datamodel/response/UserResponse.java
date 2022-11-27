package hu.bme.aut.archerybe.datamodel.response;

import java.util.List;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        String role,
        List<UUID> trainings
) {
}
