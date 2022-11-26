package hu.bme.aut.archerybe.datamodel.response;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.entity.Authority;

public record UserResponse(
        UUID id,
        String username,
        String email,
        Set<Authority> authorities,
        List<UUID> trainings
) {
}
