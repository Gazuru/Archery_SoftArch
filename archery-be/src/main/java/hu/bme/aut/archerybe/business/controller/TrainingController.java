package hu.bme.aut.archerybe.business.controller;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import hu.bme.aut.archerybe.business.service.RoundService;
import hu.bme.aut.archerybe.business.service.StatisticsService;
import hu.bme.aut.archerybe.business.service.TrainingService;
import hu.bme.aut.archerybe.datamodel.dto.RoundDto;
import hu.bme.aut.archerybe.datamodel.dto.TrainingDto;
import hu.bme.aut.archerybe.datamodel.entity.Round;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import hu.bme.aut.archerybe.datamodel.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    private final StatisticsService statisticsService;

    private final RoundService roundService;

    @GetMapping("/trainings")
    public List<Training> getTrainings() {
        return trainingService.getTrainings();
    }

    @PostMapping("/trainings")
    public Training createTraining(@RequestBody TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @GetMapping("/training/{id}")
    public Training getTraining(@PathVariable UUID id) {
        return trainingService.getTraining(id);
    }

    @PutMapping("/training/{id}")
    public Training updateTraining(@PathVariable UUID id, @RequestBody TrainingDto trainingDto){
        return trainingService.updateTraining(id, trainingDto);
    }

    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable UUID id) {
        trainingService.deleteTraining(id);
    }

    @GetMapping("/training/{id}/statistics")
    public Statistics getStatisticsForTraining(@PathVariable UUID id){
        return statisticsService.getStatisticsForTraining(id);
    }

    @GetMapping("/training/{id}/rounds")
    public Set<Round> getRoundsOfTraining(@PathVariable UUID id){
        return roundService.getRoundsOfTraining(id);
    }

    @PostMapping("/training/{id}/rounds")
    public Round createRoundForTraining(@PathVariable UUID id, @RequestBody RoundDto roundDto){
        return roundService.createRoundForTraining(id, roundDto);
    }
}