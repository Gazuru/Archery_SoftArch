package hu.bme.aut.archerybe.business.service;

import java.util.List;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.BowDto;
import hu.bme.aut.archerybe.datamodel.entity.Bow;
import hu.bme.aut.archerybe.datamodel.enums.BowType;
import hu.bme.aut.archerybe.datamodel.repository.BowRepository;
import hu.bme.aut.archerybe.datamodel.response.BowResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BowService {

    private final BowRepository bowRepository;

    public List<BowResponse> getBows() {
        return bowRepository.findAll().stream().map(this::toResponse).toList();
    }

    public BowResponse getBow(UUID id) {
        return toResponse(getBowById(id));
    }

    public Bow getBowById(UUID id) {
        return bowRepository.findById(id).orElseThrow(
                () -> new ArcheryException("Bow not found by id: " + id));
    }

    public BowResponse createBow(BowDto bowDto) {
        return saveToResponse(bowDto, new Bow());
    }

    public BowResponse updateBow(UUID id, BowDto bowDto) {
        return saveToResponse(bowDto, getBowById(id));
    }

    public void deleteBow(UUID id) {
        if (bowRepository.existsById(id)) {
            bowRepository.deleteById(id);
        }
    }

    private BowResponse toResponse(Bow bow) {
        return new BowResponse(bow.getId(), bow.getName(), bow.getBowType().toString(), bow.getDescription());
    }

    private Bow saveFromDto(BowDto bowDto, Bow bow) {
        bow.setDescription(bowDto.description());
        bow.setName(bowDto.name());
        bow.setBowType(BowType.fromValue(bowDto.type()));

        return bowRepository.save(bow);
    }

    private BowResponse saveToResponse(BowDto bowDto, Bow bow) {
        return toResponse(saveFromDto(bowDto, bow));
    }
}
