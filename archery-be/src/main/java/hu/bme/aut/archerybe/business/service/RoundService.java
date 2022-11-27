package hu.bme.aut.archerybe.business.service;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.RoundDto;
import hu.bme.aut.archerybe.datamodel.entity.Round;
import hu.bme.aut.archerybe.datamodel.repository.RoundRepository;
import hu.bme.aut.archerybe.datamodel.repository.TrainingRepository;
import hu.bme.aut.archerybe.datamodel.response.RoundResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository roundRepository;

    private final TrainingService trainingService;

    private final StatisticsService statisticsService;

    private final TrainingRepository trainingRepository;

    public Set<RoundResponse> getRoundsOfTraining(UUID trainingId) {
        return roundRepository.findAllByTrainingId(trainingId).stream().map(this::toResponse).collect(Collectors.toSet());
    }

    public RoundResponse createRoundForTraining(UUID trainingId, RoundDto roundDto) {
        var round = new Round();
        var training = trainingService.getTrainingById(trainingId);
        round.setTraining(training);

        var highestRound = roundRepository.findFirstByTrainingIdOrderByRoundNumberDesc(trainingId);
        var currentRoundNumber = Objects.isNull(highestRound) ? 1 : highestRound.getRoundNumber() + 1;
        round.setRoundNumber(currentRoundNumber);

        return saveToResponse(roundDto, round);
    }

    public RoundResponse getRound(UUID roundId) {
        return toResponse(getRoundById(roundId));
    }

    public RoundResponse updateRound(UUID roundId, RoundDto roundDto) {
        return saveToResponse(roundDto, getRoundById(roundId));
    }

    public void deleteRound(UUID roundId) {
        if (roundRepository.existsById(roundId)) {
            var training = getRoundById(roundId).getTraining();
            roundRepository.deleteById(roundId);
            statisticsService.updateStatisticsForTrainingAndUser(training);
        }
    }

    private Round getRoundById(UUID roundId) {
        return roundRepository.findById(roundId).orElseThrow(
                () -> new ArcheryException("Round cannot be found by training id:" + roundId));
    }

    private Round saveFromDto(RoundDto roundDto, Round round) {
        round.setScore(roundDto.score());
        round = roundRepository.save(round);
        round.getTraining().getRounds().add(round);
        trainingRepository.save(round.getTraining());

        statisticsService.updateStatisticsForTrainingAndUser(round.getTraining());
        return round;
    }

    private RoundResponse toResponse(Round round) {
        return new RoundResponse(round.getId(), round.getTraining().getId(), round.getScore(), round.getRoundNumber());
    }

    private RoundResponse saveToResponse(RoundDto roundDto, Round round) {
        return toResponse(saveFromDto(roundDto, round));
    }
}
