package hu.bme.aut.archerybe.business.controller;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.Valid;

import hu.bme.aut.archerybe.business.service.RoundService;
import hu.bme.aut.archerybe.business.service.TrainingService;
import hu.bme.aut.archerybe.datamodel.dto.RoundDto;
import hu.bme.aut.archerybe.datamodel.dto.TrainingDto;
import hu.bme.aut.archerybe.datamodel.response.RoundResponse;
import hu.bme.aut.archerybe.datamodel.response.TrainingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    private final RoundService roundService;

    @GetMapping("/trainings")
    public List<TrainingResponse> getTrainings() {
        return trainingService.getTrainings();
    }

    @PostMapping("/trainings")
    public TrainingResponse createTraining(@Valid @RequestBody TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @GetMapping("/training/{id}")
    public TrainingResponse getTraining(@PathVariable UUID id) {
        return trainingService.getTraining(id);
    }

    @PutMapping("/training/{id}")
    public TrainingResponse updateTraining(@PathVariable UUID id, @Valid @RequestBody TrainingDto trainingDto) {
        return trainingService.updateTraining(id, trainingDto);
    }

    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable UUID id) {
        trainingService.deleteTraining(id);
    }

    @GetMapping("/training/{id}/rounds")
    public Set<RoundResponse> getRoundsOfTraining(@PathVariable UUID id) {
        return roundService.getRoundsOfTraining(id);
    }

    @PostMapping("/training/{id}/rounds")
    public RoundResponse createRoundForTraining(@PathVariable UUID id, @Valid @RequestBody RoundDto roundDto) {
        return roundService.createRoundForTraining(id, roundDto);
    }
}
