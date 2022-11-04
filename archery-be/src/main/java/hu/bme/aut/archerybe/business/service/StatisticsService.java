package hu.bme.aut.archerybe.business.service;

import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import hu.bme.aut.archerybe.datamodel.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public Statistics getStatisticsForTraining(UUID id) {
        return getStatisticsByTrainingId(id);
    }

    private Statistics getStatisticsByTrainingId(UUID id) {
        return statisticsRepository.findByTrainingId(id).orElseThrow(
                () -> new ArcheryException("Statistics not found by training id: " + id));
    }
}
