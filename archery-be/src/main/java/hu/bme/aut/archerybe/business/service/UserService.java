package hu.bme.aut.archerybe.business.service;

import java.util.UUID;

import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import hu.bme.aut.archerybe.datamodel.entity.User;
import hu.bme.aut.archerybe.datamodel.repository.StatisticsRepository;
import hu.bme.aut.archerybe.datamodel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final StatisticsRepository statisticsRepository;

    public User getUserById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(
                () -> new ArcheryException("User not found by ID: " + uuid));
    }

    public Statistics getStatisticsOfUser(User user) {
        UUID id = user.getStatistics().getId();
        return statisticsRepository.findById(id)
                .orElseGet(() -> {
                    var statistic = new Statistics();
                    statistic = statisticsRepository.save(statistic);

                    user.setStatistics(statistic);
                    userRepository.save(user);

                    return statistic;
                });
    }
}
