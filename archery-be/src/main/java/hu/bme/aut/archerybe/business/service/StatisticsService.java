package hu.bme.aut.archerybe.business.service;

import java.util.UUID;
import java.util.stream.Collectors;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import hu.bme.aut.archerybe.datamodel.entity.Training;
import hu.bme.aut.archerybe.datamodel.entity.User;
import hu.bme.aut.archerybe.datamodel.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    private final UserService userService;

    private final TrainingService trainingService;

    public Statistics getStatisticsForUser(UUID userId) {
        return updateUserStatistics(userService.getUserById(userId));
    }

    public Statistics getStatistics(UUID statisticsId) {
        return getStatisticsById(statisticsId);
    }

    private Statistics getStatisticsById(UUID statisticsId) {
        return statisticsRepository.findById(statisticsId).orElseThrow(
                () -> new ArcheryException("Statistics not found by ID: " + statisticsId));
    }

    public Statistics updateTrainingStatistics(Training training) {
        var statistics = trainingService.getStatisticsOfTraining(training);

        var maxPoints = training.getShotsPerRound() * training.getMaxPoints();
        var rounds = training.getRounds();

        var accuracyPercentages =
                rounds.stream()
                        .map(round -> (((double) round.getScore()) / maxPoints) * 100)
                        .collect(Collectors.toSet());
        var lowestPercentage =
                accuracyPercentages.stream()
                        .min(Double::compare)
                        .orElse(0.0);
        var highestPercentage =
                accuracyPercentages.stream()
                        .max(Double::compare)
                        .orElse(0.0);
        var averagePercentage =
                accuracyPercentages.stream()
                        .mapToDouble(Number::doubleValue)
                        .average()
                        .orElse(0.0);

        statistics.setLowestAccuracyPercentage(lowestPercentage);
        statistics.setHighestAccuracyPercentage(highestPercentage);
        statistics.setAccuracyPercentageAverage(averagePercentage);

        return statisticsRepository.save(statistics);
    }

    public Statistics updateUserStatistics(User user) {
        var statistics = userService.getStatisticsOfUser(user);
        var trainings = user.getTrainings();

        var statisticsOfTrainings =
                trainings.stream()
                        .map(this::updateTrainingStatistics)
                        .toList();

        var lowestPercentage =
                statisticsOfTrainings.stream()
                        .map(Statistics::getLowestAccuracyPercentage)
                        .min(Double::compare)
                        .orElse(0.0);
        var highestPercentage =
                statisticsOfTrainings.stream()
                        .map(Statistics::getHighestAccuracyPercentage)
                        .max(Double::compare)
                        .orElse(0.0);
        var averagePercentage =
                statisticsOfTrainings.stream()
                        .map(Statistics::getAccuracyPercentageAverage)
                        .mapToDouble(Number::doubleValue)
                        .average()
                        .orElse(0.0);

        statistics.setLowestAccuracyPercentage(lowestPercentage);
        statistics.setHighestAccuracyPercentage(highestPercentage);
        statistics.setAccuracyPercentageAverage(averagePercentage);

        return statisticsRepository.save(statistics);
    }

    public void updateStatisticsForTrainingAndUser(Training training) {
        updateTrainingStatistics(training);
        updateUserStatistics(training.getUser());
    }
}
