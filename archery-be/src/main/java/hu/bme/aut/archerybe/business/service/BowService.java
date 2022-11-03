package hu.bme.aut.archerybe.business.service;

import java.util.List;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.BowDto;
import hu.bme.aut.archerybe.datamodel.entity.Bow;
import hu.bme.aut.archerybe.datamodel.repository.BowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BowService {

    private final BowRepository bowRepository;

    public List<Bow> getBows() {
        return bowRepository.findAll();
    }

    public Bow getBow(UUID id) {
        return getBowById(id);
    }

    private Bow getBowById(UUID id) {
        return bowRepository.findById(id).orElseThrow(
                () -> new ArcheryException("Bow not found by id: " + id));
    }

    public Bow createBow(BowDto bowDto) {
        var bow = new Bow();
        /* set attributes in bow based on dto */
        return bowRepository.save(bow);
    }

    public void deleteBow(UUID id) {
        if (bowRepository.existsById(id)) {
            bowRepository.deleteById(id);
        }
    }
}
