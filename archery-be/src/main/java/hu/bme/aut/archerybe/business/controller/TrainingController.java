package hu.bme.aut.archerybe.business.controller;

import java.util.List;
import java.util.UUID;

import hu.bme.aut.archerybe.business.service.TrainingService;
import hu.bme.aut.archerybe.datamodel.dto.TrainingDto;
import hu.bme.aut.archerybe.datamodel.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/trainings")
    public List<Training> getTrainings() {
        return trainingService.getTrainings();
    }

    @PostMapping("/trainings")
    public Training createTraining(TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @GetMapping("/training/{id}")
    public Training getTraining(@PathVariable UUID id) {
        return trainingService.getTraining(id);
    }

    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable UUID id) {
        trainingService.deleteTraining(id);
    }
}
