package hu.bme.aut.archerybe.business.service;

import java.util.List;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.TrainingDto;
import hu.bme.aut.archerybe.datamodel.entity.Training;
import hu.bme.aut.archerybe.datamodel.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public Training getTraining(UUID id) {
        return getTrainingById(id);
    }

    private Training getTrainingById(UUID id) {
        return trainingRepository.findById(id).orElseThrow(
                () -> new ArcheryException("Training not found by id: " + id));
    }

    public Training createTraining(TrainingDto trainingDto) {
        var training = new Training();
        /* set attributes from dto to training entity */
        return trainingRepository.save(training);
    }

    public void deleteTraining(UUID id) {
        if (trainingRepository.existsById(id)) {
            trainingRepository.deleteById(id);
        }
    }

    public Training updateTraining(UUID id, TrainingDto trainingDto) {
        var training = getTrainingById(id);
        /* set attributes from dto to training entity */
        return trainingRepository.save(training);
    }
}
