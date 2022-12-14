package hu.bme.aut.archerybe.business.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import hu.bme.aut.archerybe.config.services.UserDetailsImpl;
import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.TrainingDto;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import hu.bme.aut.archerybe.datamodel.entity.Training;
import hu.bme.aut.archerybe.datamodel.enums.Location;
import hu.bme.aut.archerybe.datamodel.repository.StatisticsRepository;
import hu.bme.aut.archerybe.datamodel.repository.TrainingRepository;
import hu.bme.aut.archerybe.datamodel.repository.UserRepository;
import hu.bme.aut.archerybe.datamodel.response.TrainingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    private final StatisticsRepository statisticsRepository;

    private final UserRepository userRepository;

    private final BowService bowService;

    @Lazy
    private final StatisticsService statisticsService;

    public List<TrainingResponse> getTrainings(UUID userId) {
        var authority =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().get(0);
        var username =
                ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        var user =
                userRepository.findByUsername(username)
                        .orElseThrow(() -> new ArcheryException("User cannot be found by username: " + username));

        if (authority.equals("ROLE_ADMIN")) {
            if (Objects.nonNull(userId)) {
                return trainingRepository.findAllByUserId(userId).stream().map(this::toResponse).toList();
            }
            return trainingRepository.findAll().stream().map(this::toResponse).toList();
        } else {
            if (Objects.nonNull(userId)) {
                if (!userId.equals(user.getId())) {
                    return trainingRepository.findAllByIsPrivateIsFalseAndUserId(userId).stream().map(this::toResponse).toList();
                } else {
                    return trainingRepository.findAllByUserId(userId).stream().map(this::toResponse).toList();
                }
            }
            return trainingRepository.findAllByIsPrivateIsFalseOrUserId(user.getId()).stream().map(this::toResponse).toList();
        }
    }

    public TrainingResponse getTraining(UUID id) {
        return toResponse(getTrainingById(id));
    }

    public Training getTrainingById(UUID id) {
        return trainingRepository.findById(id).orElseThrow(
                () -> new ArcheryException("Training not found by id: " + id));
    }

    public TrainingResponse createTraining(TrainingDto trainingDto) {
        var training = new Training();
        var statistics = statisticsRepository.save(new Statistics());
        training.setStatistics(statistics);

        var principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var currentUser = userRepository.findByUsername(principal.getUsername()).orElseThrow(
                () -> new ArcheryException("User not found by current user's username: " + principal.getUsername()));

        training.setUser(currentUser);

        return saveToResponse(trainingDto, training);
    }

    public void deleteTraining(UUID id) {
        if (trainingRepository.existsById(id)) {
            var user = getTrainingById(id).getUser();
            trainingRepository.deleteById(id);
            statisticsService.updateUserStatistics(user);
        }
    }

    public TrainingResponse updateTraining(UUID id, TrainingDto trainingDto) {
        return saveToResponse(trainingDto, getTrainingById(id));
    }

    private Training saveFromDto(TrainingDto trainingDto, Training training) {
        training.setName(trainingDto.name());
        training.setLocation(Location.fromValue(trainingDto.location()));
        training.setShotsPerRound(trainingDto.shotsPerRound());
        training.setDistance(trainingDto.distance());
        training.setMaxPoints(trainingDto.maxPoints());
        training.setBoard(trainingDto.board());
        training.setDescription(trainingDto.description());
        training.setPrivate(trainingDto.isPrivate());
        training.setBow(bowService.getBowById(trainingDto.bow()));

        training = trainingRepository.save(training);

        var user = training.getUser();
        user.getTrainings().add(training);
        userRepository.save(user);

        statisticsService.updateStatisticsForTrainingAndUser(training);
        return training;
    }

    private TrainingResponse toResponse(Training training) {
        return new TrainingResponse(training.getId(),
                training.getStatistics().getId(),
                training.getUser().getId(),
                training.getUser().getUsername(),
                training.isPrivate(),
                training.getName(),
                training.getLocation().toString(),
                training.getShotsPerRound(),
                training.getDistance(),
                training.getMaxPoints(),
                training.getBoard(),
                training.getDescription(),
                training.getBow().getId());
    }

    private TrainingResponse saveToResponse(TrainingDto trainingDto, Training training) {
        return toResponse(saveFromDto(trainingDto, training));
    }

    public Statistics getStatisticsOfTraining(Training training) {
        UUID id = training.getStatistics().getId();
        return statisticsRepository.findById(id)
                .orElseThrow(() -> new ArcheryException("Statistics not found by ID: " + id));
    }
}
