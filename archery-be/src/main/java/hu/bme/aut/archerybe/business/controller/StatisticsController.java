package hu.bme.aut.archerybe.business.controller;

import java.util.UUID;

import hu.bme.aut.archerybe.business.service.StatisticsService;
import hu.bme.aut.archerybe.datamodel.entity.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/{userId}/statistics")
    public Statistics getStatisticsForUser(@PathVariable UUID userId) {
        return statisticsService.getStatisticsForUser(userId);
    }

    @GetMapping("/statistics/{statisticsId}")
    public Statistics getStatistics(@PathVariable UUID statisticsId) {
        return statisticsService.getStatistics(statisticsId);
    }

}
