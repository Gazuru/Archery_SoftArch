package hu.bme.aut.archerybe.business.service;

import java.util.Set;
import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.RoundDto;
import hu.bme.aut.archerybe.datamodel.entity.Round;
import hu.bme.aut.archerybe.datamodel.repository.RoundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository roundRepository;

    private final TrainingService trainingService;


    public Set<Round> getRoundsOfTraining(UUID trainingId) {
        return roundRepository.findAllByTrainingId(trainingId);
    }

    public Round createRoundForTraining(UUID trainingId, RoundDto roundDto) {
        var round = new Round();
        var training = trainingService.getTraining(trainingId);
        round.setTraining(training);
        /* set up attributes based on dto */
        return roundRepository.save(round);
    }

    public Round getRound(UUID roundId) {
        return getRoundById(roundId);
    }

    public Round updateRound(UUID roundId, RoundDto roundDto) {
        var round = getRoundById(roundId);
        /* set up attributes based on dto */
        return roundRepository.save(round);
    }

    public void deleteRound(UUID roundId) {
        if (roundRepository.existsById(roundId)) {
            roundRepository.deleteById(roundId);
        }
    }

    private Round getRoundById(UUID roundId) {
        return roundRepository.findById(roundId).orElseThrow(
                () -> new ArcheryException("Round cannot be found by training id:" + roundId));
    }
}
