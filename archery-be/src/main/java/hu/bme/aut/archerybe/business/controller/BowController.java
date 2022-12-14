package hu.bme.aut.archerybe.business.controller;

import hu.bme.aut.archerybe.business.service.BowService;
import hu.bme.aut.archerybe.datamodel.dto.BowDto;
import hu.bme.aut.archerybe.datamodel.response.BowResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class BowController {

    private final BowService bowService;

    @GetMapping("/bows")
    public List<BowResponse> getBows() {
        return bowService.getBows();
    }

    @PostMapping("/bows")
    public BowResponse createBow(@Valid @RequestBody BowDto bowDto) {
        return bowService.createBow(bowDto);
    }

    @PutMapping("/bow/{id}")
    public BowResponse updateBow(@PathVariable UUID id, @Valid @RequestBody BowDto bowDto) {
        return bowService.updateBow(id, bowDto);
    }

    @GetMapping("/bow/{id}")
    public BowResponse getBow(@PathVariable UUID id) {
        return bowService.getBow(id);
    }

    @DeleteMapping("/bow/{id}")
    public void deleteBow(@PathVariable UUID id) {
        bowService.deleteBow(id);
    }
}
