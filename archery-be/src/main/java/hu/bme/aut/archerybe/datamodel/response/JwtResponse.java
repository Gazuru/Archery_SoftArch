package hu.bme.aut.archerybe.datamodel.response;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record JwtResponse(String token, UUID id, String username, String email, List<String> roles) {
    private static final String type = "Bearer";
}
