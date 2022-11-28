package hu.bme.aut.archerybe.datamodel.entity;

import hu.bme.aut.archerybe.datamodel.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    private Role role;
}
