package hu.bme.aut.archerybe.datamodel.response;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        String role
) {
}
