package hu.bme.aut.archerybe.business.controller;

import java.util.UUID;

import hu.bme.aut.archerybe.business.service.RoundService;
import hu.bme.aut.archerybe.datamodel.dto.RoundDto;
import hu.bme.aut.archerybe.datamodel.entity.Round;
import hu.bme.aut.archerybe.datamodel.response.RoundResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.path}")
public class RoundController {

    private final RoundService roundService;

    @GetMapping("/round/{roundId}")
    public RoundResponse getRound(@PathVariable UUID roundId){
        return roundService.getRound(roundId);
    }

    @PutMapping("/round/{roundId}")
    public RoundResponse updateRound(@PathVariable UUID roundId, @RequestBody RoundDto roundDto){
        return roundService.updateRound(roundId, roundDto);
    }

    @DeleteMapping("/round/{roundId}")
    public void deleteRound(@PathVariable UUID roundId){
        roundService.deleteRound(roundId);
    }
}
