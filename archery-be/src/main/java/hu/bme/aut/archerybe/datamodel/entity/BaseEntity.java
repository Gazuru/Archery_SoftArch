package hu.bme.aut.archerybe.datamodel.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class BaseEntity {

    @Id
    private UUID id;
}