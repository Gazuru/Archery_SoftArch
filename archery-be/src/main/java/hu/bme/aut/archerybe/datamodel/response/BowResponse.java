package hu.bme.aut.archerybe.datamodel.response;

import java.util.UUID;

public record BowResponse(UUID id, String name, String type, String description) {
}
