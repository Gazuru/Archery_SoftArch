package hu.bme.aut.archerybe.datamodel.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import hu.bme.aut.archerybe.datamodel.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Role role;
}
