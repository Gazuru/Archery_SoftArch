package hu.bme.aut.archerybe.business.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import hu.bme.aut.archerybe.config.services.UserDetailsImpl;
import hu.bme.aut.archerybe.datamodel.ArcheryException;
import hu.bme.aut.archerybe.datamodel.dto.UserRoleRequest;
import hu.bme.aut.archerybe.datamodel.entity.Authority;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import hu.bme.aut.archerybe.datamodel.entity.User;
import hu.bme.aut.archerybe.datamodel.enums.Role;
import hu.bme.aut.archerybe.datamodel.repository.StatisticsRepository;
import hu.bme.aut.archerybe.datamodel.repository.UserRepository;
import hu.bme.aut.archerybe.datamodel.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final StatisticsRepository statisticsRepository;

    public User getUserById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(
                () -> new ArcheryException("User not found by ID: " + uuid));
    }

    public Statistics getStatisticsOfUser(User user) {
        if (Objects.isNull(user.getStatistics())) {
            user.setStatistics(statisticsRepository.save(new Statistics()));
            userRepository.save(user);
        }
        UUID id = user.getStatistics().getId();
        return statisticsRepository.findById(id)
                .orElseThrow(() -> new ArcheryException("Cannot find statistics by ID: " + id));
    }

    public UserResponse updateRole(UUID userId, UserRoleRequest userRoleRequest) {
        User user = getUserById(userId);

        var authority = new Authority(Role.fromValue(userRoleRequest.role()));
        user.setAuthority(authority);

        var newAuthority = UserDetailsImpl.mapToGrantedAuthority(authority);

        SecurityContextHolder.getContext()
                .setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                                SecurityContextHolder.getContext().getAuthentication().getCredentials(), newAuthority));

        return toResponse(userRepository.save(user));
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getAuthority().getRole().toString());
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(this::toResponse).toList();
    }

    public UserResponse getUser(UUID userId) {
        return toResponse(getUserById(userId));
    }
}
